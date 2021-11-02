import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

fun main() {
    val socket = DatagramSocket().also { it.broadcast = true }
    var counter = 0
    while (true) {
        try {
            val sendData = "1488".toByteArray()
            socket.send(
                DatagramPacket(
                    sendData,
                    sendData.size,
                    InetAddress.getByName("255.255.255.255"),
                    12345
                )
            )
            println(">>> Request packet sent to: 255.255.255.255 (DEFAULT) with data - $counter")
            counter += 1
        } catch (e: Exception) {
        }
        Thread.sleep(300)
    }
}