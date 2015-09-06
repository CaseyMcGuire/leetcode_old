
#include <stdio.h>
#include <stdlib.h>

//                  1000, 500, 100, 50, 10, 5, 1
char mappings[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I' };
int places[] = {1000,100,10,1};

void fill_up(int cur_place, int mapping_index, int* str_index, char* str, int* cur_total);

char* intToRoman(int num) {
  
  //Largest roman numeral possible is 3888 (MMMDCCCLXXXVIII)
  char* str = malloc(16 * sizeof(char));
  int i, str_index = 0, mapping_index = 0;
  for(i = 0; num != 0; i++) {
    fill_up(i, mapping_index, &str_index, str, &num);
    mapping_index += 2;
  }
  str[str_index] = '\0';
  return str;
}

void fill_up(int cur_place, int mapping_index, int* str_index, char* str, int* cur_total) {
  int num_times_into = (*cur_total)/places[cur_place];

  if(num_times_into >= 1 && num_times_into < 4) {
    int i;
    for(i = 0; i < num_times_into; i++) {
      str[*str_index] = mappings[mapping_index];
      (*str_index)++;
    }
  }
  else if(num_times_into == 4) {
    str[*str_index] = mappings[mapping_index];
    (*str_index)++;
    str[*str_index] = mappings[mapping_index-1];
    (*str_index)++;
  }
  else if(num_times_into >= 5 && num_times_into < 9) {
    str[*str_index] = mappings[mapping_index - 1];
    (*str_index)++;
    int i;
    for(i = 0; i < num_times_into - 5; i++) {
      str[*str_index] = mappings[mapping_index];
      (*str_index)++;
    }
  }
  else if(num_times_into == 9){
    str[*str_index] = mappings[mapping_index];
    (*str_index)++;
    str[*str_index] = mappings[mapping_index - 2];
    (*str_index)++;
  }
  *cur_total -= (num_times_into * places[cur_place]);
}


void run_test(char* result, char* expected) {
  if(!strcmp(result, expected)) {
    printf("PASS\n");
  } else {
    printf("FAIL. Expected: %s Result: %s\n", expected, result);
  }
}

int main(int argc, char* argv[]) {
  

  run_test(intToRoman(1000), "M");
  run_test(intToRoman(2000), "MM");
  run_test(intToRoman(3000), "MMM");


  run_test(intToRoman(900), "CM");
  run_test(intToRoman(1900), "MCM");


  run_test(intToRoman(800), "DCCC");
  run_test(intToRoman(700), "DCC");
  run_test(intToRoman(600), "DC");
  run_test(intToRoman(500), "D");
  
  run_test(intToRoman(400), "CD");
  
  run_test(intToRoman(300), "CCC");
  run_test(intToRoman(200), "CC");
  run_test(intToRoman(100), "C");
  
  run_test(intToRoman(90), "XC");
  run_test(intToRoman(80), "LXXX");
  run_test(intToRoman(70), "LXX");
  run_test(intToRoman(60), "LX");
  run_test(intToRoman(50), "L");

  run_test(intToRoman(1), "I");

}
