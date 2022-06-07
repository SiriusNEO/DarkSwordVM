#include "ravel/ravel.h"
#include "ravel/darksword_ravel_RavelControl.h"

#include <stdio.h>

JNIEXPORT jint JNICALL Java_darksword_ravel_RavelControl_connect
  (JNIEnv * env, jclass instance, jstring testWord) {
    try {
        char* word_cpp = (char *) env->GetStringUTFChars(testWord, NULL);
        std::string word(word_cpp);
        printf("[ravel] Connecting to DarkSword... Success. Test Word: %s\n", word.c_str());
        env->ReleaseStringUTFChars(testWord, word_cpp);
    } catch(...) {
        return 1;
    }

    return 0;
  }

JNIEXPORT jint JNICALL Java_darksword_ravel_RavelControl_simulate
(JNIEnv *env, jclass instance, jstring code, jintArray regs, jbyteArray mem, jint memSize, jboolean display) {
    if (display) {
        printf("[ravel] Execute call from DarkSword...\n");
        printf("[ravel] RegNum= %d, MemSize= %d (bytes)\n", 32, memSize);
    }
    
    char* code_cpp = (char *) env->GetStringUTFChars(code, NULL);
    std::string src(code_cpp);
    
    uint32_t* regs_cpp = (uint32_t *) env->GetIntArrayElements(regs, NULL);
    std::byte* mem_cpp = (std::byte*) env->GetByteArrayElements(mem, NULL);

    if (display) {
        printf("[ravel] Initial Reg:");
        for (int i = 0; i < 32; ++i) {
            printf(" x%d=%d", i, regs_cpp[i]);
        }
        printf("\n");
    }

    jint ret = ravel::simulate(src, regs_cpp, mem_cpp, mem_cpp + memSize);
    jint a0 = 0xffffu & regs_cpp[10];

    env->ReleaseStringUTFChars(code, code_cpp);
    env->ReleaseIntArrayElements(regs, (jint*) regs_cpp, JNI_COMMIT);
    env->ReleaseByteArrayElements(mem, (jbyte*) mem_cpp, JNI_COMMIT);
    env->ReleaseIntArrayElements(regs, (jint*) regs_cpp, 0);
    env->ReleaseByteArrayElements(mem, (jbyte*) mem_cpp, 0);
    
    if (display) {
        printf("[ravel] Finish. Time= %d (cycle), ExitCode= %d\n", ret, a0);
    }

    if (display) {
        printf("[ravel] Finish Reg: ");
        for (int i = 0; i < 32; ++i) {
            printf(" x%d=%d", i, regs_cpp[i]);
        }
        printf("\n");
    }
    
    return ret;
}