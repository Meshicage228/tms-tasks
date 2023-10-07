
import horseRacing.com.domain.RacingGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RacingMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("horseRacing.com");
        applicationContext.registerShutdownHook();

        // Разные кошельки
        RacingGame firstRace = applicationContext.getBean(RacingGame.class);

        firstRace.startGame();

        RacingGame secondRace = applicationContext.getBean(RacingGame.class);

        secondRace.startGame();

    }
}
