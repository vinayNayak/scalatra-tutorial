import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext

object JettyEmbedded extends  App{

  val server = new Server()
  val connector = new SelectChannelConnector()
  connector.setPort(8080)
  server.addConnector(connector)
  val context: WebAppContext = new WebAppContext("src/main/webapp", "/")
  context.setServer(server)
  server.setHandler(context)

  try{
    server.start()
    server.join()
  }catch {
    case e: Exception =>
      e.printStackTrace()
      System.exit(1)
  }

}
