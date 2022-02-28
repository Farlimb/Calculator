#include "greatest.h"

extern SUITE(all_possible_tests);

GREATEST_MAIN_DEFS();

int main(int argc, char **argv) {
    GREATEST_MAIN_BEGIN();
    RUN_SUITE(all_possible_tests);
    GREATEST_MAIN_END();
}
