package machine
class Machine (var water: Int, var milk: Int, var beans:Int, var cups:Int, var money:Int)
fun main() {
    val machine = Machine(400, 540, 120, 9, 550)
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readln()) {
            "buy" -> buy(machine)
            "fill" -> fill(machine)
            "take" -> take(machine)
            "remaining" -> printMachine(machine)
            "exit" -> return
        }
    }
}
fun buy (machine: Machine) {
print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    when (readln()) {
        "1" -> { if (machine.water - 250 >=0 && machine.beans - 16 >= 0) {
            machine.water -= 250; machine.beans -= 16; machine.money += 4; machine.cups -= 1
            println("I have enough resources, making you a coffee!")
        } else if (machine.water - 250 <0) println("Sorry, not enough water!") else println("Sorry, not enough beans!")
        }
        "2" -> { if (machine.water - 350 >=0 && machine.beans - 20 >= 0 && machine.milk - 75 >=0) {
            machine.water -= 350; machine.milk -= 75; machine.beans -= 20; machine.money += 7; machine.cups -= 1
            println("I have enough resources, making you a coffee!")
        } else if (machine.water - 350 <0) println("Sorry, not enough water!") else if (machine.beans - 20 < 0) println("Sorry, not enough beans") else println("Sorry, not enough milk!")
        }
        "3" -> { if (machine.water - 200 >=0 && machine.beans - 12 >= 0 && machine.milk - 100 >=0) {
            machine.water -= 200; machine.milk -= 100; machine.beans -= 12; machine.money += 6; machine.cups -= 1
            println("I have enough resources, making you a coffee!")
        } else if (machine.water - 200 <0) println("Sorry, not enough water!") else if (machine.beans - 12 < 0) println("Sorry, not enough beans") else println("Sorry, not enough milk!")
        }
        "back" -> return
    }
    println()
}
fun fill (machine: Machine) {
    print("Write how many ml of water do you want to add: ")
    val addWater = readln().toInt()
    print("Write how many ml of milk do you want to add: ")
    val addMilk = readln().toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    val addBeans = readln().toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    val addCups = readln().toInt()
    machine.water += addWater; machine.milk += addMilk; machine.beans += addBeans; machine.cups += addCups
}
fun take (machine: Machine) {
println("I gave you $${machine.money}")
    machine.money = 0
}
fun printMachine (machine: Machine) {
    println()
    print("""The coffee machine has:
${machine.water} ml of water
${machine.milk} ml of milk
${machine.beans} g of coffee beans
${machine.cups} disposable cups
$${machine.money} of money""".trimIndent())
    println("\n")
}
