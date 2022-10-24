package com.example.relampagomarquinhos.repository

import com.example.relampagomarquinhos.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserRepository private constructor(){
    companion object{
        private  var repository:UserRepository? = null

        fun instance(): UserRepository{
            if(repository == null){
                repository = UserRepository()
            }
            return repository!!
        }
    }

    fun save(user: User){
        val database = Firebase.firestore
        database.collection("corridas")
            .add(user)
    }

    fun delete(user: User){
        val database = Firebase.firestore
        database.collection("corridas")
            .document(user.id!!)
            .delete()
    }

    fun getAll(callback:(List<User>) -> Unit){
        val database = Firebase.firestore
        database.collection("corridas")
            .get()
            .addOnSuccessListener{ documents ->
                val users = arrayListOf<User>()
                for(document in documents){
                    val user = User(
                        id = document.id,
                        name = document.get("name").toString(),
                        car = document.get("car").toString(),
                        category = document.get("category").toString(),
                        age = document.getLong("age")!!.toInt(),
                        phone = document.get("phone").toString(),
                        whp = document.getLong("whp")!!.toInt()
                    )
                    users.add(user)
                }
                callback(users)
            }
    }
}