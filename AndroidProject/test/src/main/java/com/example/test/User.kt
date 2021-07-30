package com.example.test

//在将此类标记为 data 类后，编译器便会自动创建 getter 和 setter。此外，其还会派生 equals()、hashCode() 和 toString() 函数。
data class User(var firstName: String?, var lastName: String?=null)
