package pl.dawid0604.carhunters.car.service.dao;

/**
 * Enum representing the type of petrol used in a car.
 *
 * <p>
 *     This enum is used in the {@link AdvertisementEntity} to
 *     specify which petrol is used by car.
 * </p>
 */
public enum PetrolType {

    /**
     * Gasoline (pol. Benzyna).
     */
    GASOLINE,

    /**
     * Diesel (pol. Olej napędowy).
     */
    DIESEL,

    /**
     * LPG (pol. Autogaz).
     */
    LPG,

    /**
     * CNG (pol. Sprężony gaz ziemny).
     */
    CNG,

    /**
     * Hybrid (pol. Hybryda).
     */
    HYBRID,

    /**
     * Electric (pol. Elektryk).
     */
    ELECTRIC,

    /**
     * Hydrogen (pol. Wodór).
     */
    HYDROGEN
}
