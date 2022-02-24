#include <stdio.h>
#include <string.h>
#include "fj.h"
#define UNDEF -1
#define MAX_LEN 64
#define ACCEPT 1
#define NON_ACCEPT -1

int state = 0;
int b_number = 0;  //spocitavanie poctu b na zaciatku retazca
int mandatory = 0;  //spocitavanie minimalneho retazcu
void start(char c) {
    if (c == 'a' && b_number==0) {
        state = 1;
        mandatory++;
    } else if (c == 'b' && b_number==0) {
        state = 0;
        b_number++;
    } else if (c=='b' && b_number==1) {
        state = 1;
        b_number++;
        mandatory++;
    } else {
        state = UNDEF;
    }
}

void q1(char c) {
    if (c == 'a') {
        state = 2;
        mandatory++;
    }
    else{
        state = UNDEF;
    }
}

void q2(char c) {
    if (c == 'b') {
        state = 2;
    } else if(c == 'a'){
        state = 3;
        mandatory++;
    }
    else{
    state = UNDEF;
    }
}

void q3(char c) {
    if (c == 'c') {
        state = 6;
        mandatory++;
    } else {
        state = UNDEF;
    }
}



int isAccepted(char *in_str) {
    int i=0;
    state=0;
    mandatory=0;
    b_number=0;
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
        else if (state == 6) {
            state =UNDEF;
        }
    }
    
    if(mandatory<4){  //check na minimalny retazec
    state = UNDEF;
    }
    
    if (state > 0) {
        return 1;
    } else {
        return 0;
    }
}
