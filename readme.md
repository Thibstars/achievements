# Achievements #
Sample application showing a possible approach in programming an achievements system in Java.

You can run the main method in the Achievements class to start play around with this example.

```
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
```