#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* intToRoman(int num) {
  char* str = malloc(30 * sizeof(char));
  int i;
  for(i = 0; num != 0; i++) {
    get_next_numerals(str, &i, &num);
  }
  str[i] = '\0';
  return str;
}

get_next_numerals(char* str, int* index, int* total) {
  if(*total >= 1000) {
    str[*index] = 'M';
    *total -= 1000;
  }
  else if(*total >= 900) {
    str[*index] = 'C';
    (*index)++;
    str[*index] = 'M';
    *total -= 900;
  }
  else if(*total >= 500) {
    str[*index] = 'D';
    while(*total >= 600) {
      (*index)++;
      str[*index] = 'C';
      *total -= 100;
    }
    *total -= 500;
  }
  else if(*total >= 400) {
    str[*index] = 'C';
    (*index)++;
    str[*index] = 'D';
    *total -= 400;
  }
  else if(*total >= 100) {
    str[*index] = 'C';
    *total -= 100;
  }
  else if(*total >= 90) {
    str[*index] = 'X';
    (*index)++;
    str[*index] = 'C';
    *total -= 90;
  }
  else if(*total >= 50) {
    str[*index] = 'L';
    while(*total >= 60) {
      (*index)++;
      str[*index] = 'X';
      *total -= 10;
    }
    *total -= 50;
  }
  else if(*total >= 40) {
    str[*index] = 'X';
    (*index)++;
    str[*index] = 'L';
    *total -= 40;
  }
  else if(*total >= 10) {
    str[*index] = 'X';
    *total -= 10;
  }
  else if(*total == 9) {
    str[*index] = 'I';
    (*index)++;
    str[*index] = 'X';
    *total -= 9;
  }
  else if(*total >= 5) {
    str[*index] = 'V';
    while(*total >= 6) {
      (*index)++;
      str[*index] = 'I';
      *total -= 1;
    }
    *total -= 5;
  }
  else if(*total == 4) {
    str[*index] = 'I';
    (*index)++;
    str[*index] = 'V';
    *total -= 4;
  }
  else {
    str[*index] = 'I';
    (*total)--;
  }


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
