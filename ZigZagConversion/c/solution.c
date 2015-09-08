#include <stdlib.h>
#include <string.h>
#include <stdio.h>
char* convert(char* s, int numRows) {
  int str_length = strlen(s);
  char zigzag[numRows][str_length];
  int i,j,k;

  //clear garbage out of our 2d array
  for(i = 0 ; i < numRows ; i++) {
    for(j = 0 ; j < str_length ; j++) {
      zigzag[i][j] = '\0';
    }
  }
  
  //zigging means we're going down
  //zagging means we're going up and across
  int zigging = 1;
  i = 0;
  j = 0;
  for(k = 0 ; k < str_length; k++) {
    zigzag[i][j] = *(s + k);
    
    //gotta take care of the corner case where there is only one row
    if(numRows == 1) {
      j++;
    }
    else if(zigging) {
      i++;
    } 
    else {
      j++;
      i--;
    }
    //if we're at the top, we need to start zagging. If we're at the bottom, we need to start zigging.
    if(i == (numRows - 1)) zigging = 0;
    else if(i == 0) zigging = 1;
  }
  
  k = 0;
  char* str_to_return = malloc((str_length + 1) * sizeof(char));
  for(i = 0 ; i < numRows ; i++) {
    for(j = 0 ; j < str_length ; j++) {
      if(zigzag[i][j] != '\0') {
	str_to_return[k] = zigzag[i][j];
	k++;
      }
    }
  }
  //null terminate our string
  str_to_return[k] = '\0';
  return str_to_return;
}

void run_test(char* result, char* expected) {
  if(!strcmp(result, expected)) {
    printf("PASS\n");
  } else {
    printf("FAIL. Expected: %s . Result: %s\n", expected, result);
  }
}

int main(int argc, char* argv[]) {
  run_test(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
  run_test(convert("PAYPALISHIRING", 1), "PAYPALISHIRING");
  run_test(convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
  return 0;
}
