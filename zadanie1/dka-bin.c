#include <stdio.h>
#include <string.h>
#include "fj.h"
#define UNDEF -1
#define MAX_LEN 64
#define ACCEPT 1
#define NON_ACCEPT -1

int state = 0;
void start(char c) {
    if (c == 'a') {
        state = 4;
    }
     else if (c == 'b') {
        state = 1;
    } else {
        state = UNDEF;
    }
}

void q1(char c) {
    if (c == 'b') {
        state = 2;
    }
    else{
        state = UNDEF;
    }
}

void q2(char c) {
    if (c == 'a') {
        state = 3;
    } 
    else{
    state = UNDEF;
    }
}

void q3(char c) {
    if (c == 'b') {
        state = 3;
        }
    else if(c == 'a'){
        state = 6;
    }
     else {
        state = UNDEF;
    }
}
void q4(char c) {
    if (c == 'a') {
        state = 5;
    }
    else if(c == 'b'){
        state = 3;
    }
     else {
        state = UNDEF;
    }
}
void q5(char c) {
    if (c == 'c') {
        state = 7;
    } 
    else if(c == 'a'){
        state = 6;
    }
    else if(c == 'b'){
        state = 3;
    }
    
    else {
        state = UNDEF;
    }
}
void q6(char c) {
    if (c == 'c') {
        state = 7;
    } else {
        state = UNDEF;
    }
}



int isAccepted(char *in_str) {
    int i=0;
    state=0;
    int len = strlen(in_str);
    for (i = 0; i < len; i++) {
        if (state == 0) {
            start(in_str[i]);
        } 
        else if (state == 1) {
            q1(in_str[i]);
        } else if (state == 2) {
            q2(in_str[i]);
        }
        else if (state == 3) {
            q3(in_str[i]);
        }
        else if (state == 4) {
            q4(in_str[i]);
        }
        else if (state == 5) {
            q5(in_str[i]);
        }
        else if (state == 6) {
            q6(in_str[i]);
        }
        else if (state == 8) {
            state =UNDEF;
        }
    }
    
    if (state > 0) {
        return 1;
    } else {
        return 0;
    }
}
