# 1. 新建项目 
删除冗余文件夹，如androidTest test文件夹（无测试要求）
# 2. 统一管理依赖库
复制==setting.gradle== 粘贴为 ==versions.gradle==
修改为以下内容
    
    /**
     * Shared file between builds so that they can all use the same dependencies and
     * maven repositories.
     **/
    
    ext.deps = [:]
    def versions = [:]
    
    versions.support = "26.1.0"
    versions.constraint = "1.1.2"
    versions.butterknife = "8.5.1"
    
    // support 相关的逻辑
    def support = [:]
    support.annotations = "com.android.support:support-annotations:$versions.support"
    support.app_compat = "com.android.support:appcompat-v7:$versions.support"
    support.recyclerview = "com.android.support:recyclerview-v7:$versions.support"
    support.design = "com.android.support:design:$versions.support"
    support.percent = "com.android.support:percent:$versions.support"
    support.v4 = "com.android.support:support-v4:$versions.support"
    support.v13 = "com.android.support:support-v13:$versions.support"
    support.core_utils = "com.android.support:support-core-utils:$versions.support"
    support.fragment = "com.android.support:support-fragment:$versions.support"
    support.emoji = "com.android.support:support-emoji:$versions.support"
    
    // constraint 相关
    support.constraint = "com.android.support.constraint:constraint-layout:$versions.constraint"
    
    // butterknife 相关
    deps.butterknife = "com.jakewharton:butterknife:$versions.butterknife"
    deps.butterknife_compiler = "com.jakewharton:butterknife-compiler:$versions.butterknife"
    
    deps.support = support
    ext.deps = deps
    
# 3. 修改预编译gradle
修改项目==build.gradle==


    // Top-level build file where you can add configuration options common to all sub-projects/modules.
    
    buildscript {
        //添加预编译
        apply from: 'versions.gradle'
    
        repositories {
            google()
            jcenter()
        }
        dependencies {
            classpath 'com.android.tools.build:gradle:3.1.4'
            
    
            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files
        }
    }
    
    allprojects {
        repositories {
            google()
            jcenter()
        }
    }
    
    task clean(type: Delete) {
        delete rootProject.buildDir
    }

    