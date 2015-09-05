#include <stdio.h>
#include <string.h>
int romanToInt(char* s);
int is_negative(char* s, int i);
int get_roman_value(char c);

/* Convert the passed roman numeral (as a string) to an integer.
   Note: We assume the roman numeral is valid and between 1 and 3999.
*/
int romanToInt(char* s) {
  int total = 0;
  int i = 0;
  int length = strlen(s);

  for(;i < length - 1; i++) {
    int cur_value = get_roman_value(s[i]);

    if(is_negative(s,i)) {
      total -= cur_value;
    } else {
      total += get_roman_value(s[i]);
    }
  }

  total += get_roman_value(s[i]);
  return total;
}

/* Determine if the character at the ith index of the string is a 
   negative contributor to the total value. */
int is_negative(char* s, int i) {
  int first = get_roman_value(s[i]);
  int second = get_roman_value(s[i+1]);
  if(first < second) {
    return 1;
  } else {
    return 0;
  }
}

/*
  Return the integer value for a single roman numberal between 1 and 1000.
 */
int get_roman_value(char c) {
  switch(c) {
  case 'I':
    return 1;
  case 'V':
    return 5;
  case 'X':
    return 10;
  case 'L':
    return 50;
  case 'C':
    return 100;
  case 'D':
    return 500;
  case 'M':
    return 1000;
  default:
    return -1;
  }
}

void run_test(char* roman_numeral, int expected_int) {
  int result = romanToInt(roman_numeral);
  if(result == expected_int) {
    printf("PASS\n");
  } else {
    printf("FAIL. Expected: %d, Actual: %d\n", expected_int, result);
  }
}

int main(int argc, char* argv[]) {

  //Easy
  run_test("I", 1);
  run_test("V", 5);
  run_test("X", 10);
  run_test("L", 50);
  run_test("C", 100);
  run_test("D", 500);
  run_test("M", 1000);

  //compound
  run_test("III", 3);
  run_test("VI", 6);
  run_test("LX", 60);
  run_test("LII", 52);
  run_test("ML", 1050);

  //negative
  run_test("IV", 4);
  run_test("CM", 900);
  return 0;
}
