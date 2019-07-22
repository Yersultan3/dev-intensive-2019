package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        var user = User("1")
        var user2 = User("2")
        var user3 = User("3")

//        user.printMe()

        println("$user $user2 $user3")
    }

    @Test
    fun test_factory(){
//        var user = User.makeUser("John Cena")
//        var user1 = User.makeUser("John Wick")
        val user = User.makeUser(null)
        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user \n $user2")

    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")

        println("${user.component1()}, ${user.component2()}, `${user.component3()}")
    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))


        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())



//        if (user == user2){
//            println("equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2 ")
//        }else {
//            println("not equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2 ")
//
//        }
//        if (user === user2){
//            println("equals data and hash ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        }else {
//            println("not equals data and hash ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//
//        }
    }

    @Test
    fun test_dataq_maping(){
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)

        val userView = newUser.toUserView()

        userView.printMe()

    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Макеев Михаил")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type="text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image message", type="image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())

    }

}
