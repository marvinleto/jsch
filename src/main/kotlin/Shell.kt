import com.jcraft.jsch.JSch

object Shell {

    fun open(host: String) {

        val jsch = JSch()

        val user = host.split("@").first()

        val session = jsch.getSession(user, host, 22)

        session.connect(30000)

        val channel = session.openChannel("shell")

        channel.inputStream = System.`in`
        channel.outputStream = System.out

        channel.connect(3000)

    }

}
