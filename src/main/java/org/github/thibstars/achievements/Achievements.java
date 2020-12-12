package org.github.thibstars.achievements;

import java.util.ArrayList;
import lombok.extern.log4j.Log4j2;

/**
 * @author Thibault Helsmoortel
 */
@Log4j2
public class Achievements {

    public static void main(String[] args) {
        ArrayList<AchievementProperty> properties = new ArrayList<>();
        AchievementProperty runApplicationAchievementProperty = new AchievementProperty("Ran application.", ActivationMethod.ACTIVE_IF_GREATER_THAN, 0, 0);
        properties.add(runApplicationAchievementProperty);
        Achievement easyAchievement = new Achievement("Easy Achievement", "The easiest achievement to achieve.", properties);

        easyAchievement.addPropertyChangeListener(event -> {
            if ((Boolean) event.getNewValue()) {
                log.info("We have achieved the achievement!");
            }
        });

        runApplicationAchievementProperty.incrementValue(); // We are running the application, so increment the value
        easyAchievement.achieve(); // Try to unlock the achievement
    }

}
