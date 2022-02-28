#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "greatest.h"
#include "fj.h"


TEST verify_a() {
    ASSERT_EQ(isAccepted("bbaac"),1);
    PASS();
}

TEST verify_b() {
    ASSERT_EQ(isAccepted("bbaac"),1);
    PASS();
}

TEST verify_c() {
    ASSERT_EQ(isAccepted("bbabbbbbbbbbbbbbbbbbbbbbbac"),1);
    PASS();
}

TEST verify_d() {
    ASSERT_EQ(isAccepted("aabbbbbbbbbbbbbbbac"),1);
    PASS();
}

TEST verify_e() {
    ASSERT_EQ(isAccepted("aac"),1);
    PASS();
}

TEST verify_f() {
    ASSERT_EQ(isAccepted("baac"),0);
    PASS();
}

TEST verify_g() {
    ASSERT_EQ(isAccepted("bbbaac"),0);
    PASS();
}

TEST verify_h() {
    ASSERT_EQ(isAccepted("abaac"),0);
    PASS();
}

TEST verify_i() {
    ASSERT_EQ(isAccepted("caabac"),0);
    PASS();
}

TEST verify_j() {
    ASSERT_EQ(isAccepted("acaac"),0);
    PASS();
}


SUITE (all_possible_tests) {
    RUN_TEST(verify_a);
    RUN_TEST(verify_b);
    RUN_TEST(verify_c);
    RUN_TEST(verify_d);
    RUN_TEST(verify_e);
    RUN_TEST(verify_f);
    RUN_TEST(verify_g);
    RUN_TEST(verify_h);
    RUN_TEST(verify_i);
    RUN_TEST(verify_j);
}
