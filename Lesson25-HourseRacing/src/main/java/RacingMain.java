import domain.RacingGame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RacingMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myConfiguration.xml");

        RacingGame bean = applicationContext.getBean(RacingGame.class);
        bean.startGame();

    }
}
