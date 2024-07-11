package com.panicdev.realmsample.db


//object RealmDbHelper {
//    private val mRealmConfig: RealmConfiguration by lazy {
//        RealmConfiguration.Builder()
//            .name("diary.realm")
//            .schemaVersion(1)
//            .allowWritesOnUiThread(true)
//            .build()
//    }
//
//    private var mRealmInstance: Realm? = null
//
//    private fun getInstance(): Realm {
//        if (mRealmInstance == null || mRealmInstance?.isClosed == true) {
//            mRealmInstance = Realm.getInstance(mDiaryConfig)
//        }
//        return mRealmInstance!!
//    }
//
//    fun getTemporaryInstance() = Realm.getInstance(mDiaryConfig)!!
//
//    fun closeInstance() {
//        mRealmInstance?.close()
//    }
//
//    fun getRealmPath(): String {
//        return getInstance().path
//    }
//
//    fun beginTransaction() {
//        getInstance().beginTransaction()
//    }
//
//    fun commitTransaction() {
//        getInstance().commitTransaction()
//    }
//
//    fun clearSelectedStatus() {
//        getInstance().executeTransaction { realm ->
//            realm.where(Diary::class.java).equalTo("isSelected", true).findAll().forEach { diaryDto ->
//                diaryDto.isSelected = false
//            }
//        }
//    }
//
//    fun <E : RealmModel?> copyFromRealm(realmObjects: Iterable<E>?): MutableList<E> = getInstance().copyFromRealm(realmObjects)
//
//}