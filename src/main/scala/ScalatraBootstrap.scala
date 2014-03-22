import javax.servlet.ServletContext
import org.scalatra.LifeCycle
import com.pinnacle.servlet.{AuctionServlet, MainServlet}

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {
    context.mount(new MainServlet(), "/hello/*")
    context.mount(new AuctionServlet, "/auction/*")
  }

}
