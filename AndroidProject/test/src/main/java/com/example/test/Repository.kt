package com.example.test

import java.util.*

class Repository
private constructor() {
//    private val users: MutableList<User>? = null
    private val users= mutableListOf<User>()//非null
    fun getUsers(): List<User> {
        return users
    }

    val formattedUserNames: List<String>
        get() {
            val userNames=ArrayList<String>(users.size)
            for ((firstName,lastName) in users) {
                val name: String
                if (lastName != null) {
                    if (firstName != null) {
                        name="$firstName $lastName"
                    } else {
                        name=lastName
                    }
                } else{
                    name=firstName?:"Unknown"
                }
                userNames.add(name)
            }
            return userNames
        }

    //Kotlin的“静态”属性与“静态”方法
    companion object {
        private var INSTANCE: Repository? = null
        val instance: Repository?
            get() {
                if (INSTANCE == null) {
                    synchronized(Repository::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = Repository()
                        }
                    }
                }
                return INSTANCE
            }
    }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")
//        users = ArrayList()
        //我们都使用了非 null 断言运算符 !!。该运算符可将所有变量转换为非 null 类型，并在值为 null 时抛出异常。
        users.add(user1)
        users.add(user2)
        users.add(user3)
    }
}