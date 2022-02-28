#include <stdio.h>
#include <string.h>
#include "fj.h"
#define UNDEF -1
#define MAX_LEN 64
#define ACCEPT 1
#define NON_ACCEPT -1


int main() {
    char str[MAX_LEN];
    printf("Zadaj vstupny retazec: ");
    fgets(str, MAX_LEN, stdin);
    
    str[strcspn(str, "\n")] = 0;
    
    printf("\nVstupny retazec: %s, dlzka retazca: %i", str, (int) strlen(str));
    printf("\nStav: %c", isAccepted(str) == ACCEPT ? 'A' : 'N');
    
    return 0;
}
