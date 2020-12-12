package org.github.thibstars.achievements;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Thibault Helsmoortel
 */
@Log4j2
public class Achievement implements Achievable {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    private final List<AchievementProperty> properties;

    @Getter
    private boolean unlocked;

    private final PropertyChangeSupport propertyChangeSupport;

    /**
     * Class constructor specifying name, description and properties to be activated.
     *
     * @param name the untranslated name of the achievement
     * @param description the untranslated description of the achievement
     * @param properties the properties related to the achievement
     */
    public Achievement(String name, String description, List<AchievementProperty> properties) {
        this.name = name;
        this.description = description;
        this.properties = properties;
        this.unlocked = false;

        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * Unlocks this achievement and notifies its' observers.
     */
    @Override
    public void achieve() {
        log.debug("Attempting to unlock achievement.");
        if (!unlocked) {
            boolean allActive = true;
            for (AchievementProperty property : properties) {
                if (!property.isActive()) {
                    log.info("Achievement could not be unlocked at this point.");
                    allActive = false;
                    break;
                }
            }
            if (allActive) {
                log.info("Achievement unlocked!");
                propertyChangeSupport.firePropertyChange("unlocked", this.unlocked, true);
                this.unlocked = true;
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.removePropertyChangeListener(pcl);
    }
}