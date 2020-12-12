package org.github.thibstars.achievements;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thibault Helsmoortel
 */
public class AchievementProperty {

    @Getter
    @Setter
    private String name;

    @Getter
    private int value;

    @Getter
    @Setter
    private ActivationMethod activationMethod;

    @Getter
    @Setter
    private int activationValue;

    @Getter
    @Setter
    private int initialValue;

    @Getter
    @Setter
    private String tag;

    /**
     * Class constructor specifying name, activation, activation value and initial value.
     *
     * @param name the untranslated name of the property
     * @param activationMethod the activation method of the property
     * @param activationValue the activation value of the property
     * @param initialValue the initial value of the property
     */
    public AchievementProperty(String name, ActivationMethod activationMethod, int activationValue, int initialValue) {
        this.name = name;
        this.activationMethod = activationMethod;
        this.activationValue = activationValue;
        this.initialValue = initialValue;
    }

    /**
     * Class constructor specifying name, activation, activation value, initial value and tag.
     *
     * @param name the untranslated name of the property
     * @param activationMethod the activation method of the property
     * @param activationValue the activation value of the property
     * @param initialValue the initial value of the property
     * @param tag the tag of the property
     */
    public AchievementProperty(String name, ActivationMethod activationMethod, int activationValue, int initialValue, String tag) {
        this.name = name;
        this.activationMethod = activationMethod;
        this.activationValue = activationValue;
        this.initialValue = initialValue;
        this.tag = tag;
    }

    /**
     * Returns true when this property is active, false if otherwise.
     *
     * @return true when this property is active, false if otherwise
     */
    public boolean isActive() {
        return switch (activationMethod) {
            case ACTIVE_IF_GREATER_THAN -> value > activationValue;
            case ACTIVE_IF_LESS_THAN -> value < activationValue;
            case ACTIVE_IF_EQUALS_TO -> value == activationValue;
        };
    }

    /**
     * Adds a provided value to the current value.
     *
     * @param value the value to add
     */
    public void addValue(int value) {
        this.value += value;
    }

    /**
     * Increments the value by 1.
     */
    public void incrementValue() {
        this.value++;
    }

    /**
     * Decrements the value by 1.
     */
    public void decrementValue() {
        this.value--;
    }

    /**
     * Resets this property's current value.
     */
    public void reset() {
        this.value = initialValue;
    }
}
