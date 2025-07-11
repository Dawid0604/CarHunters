package pl.dawid0604.carhunters.car.service.dao;

/**
 * Enum representing the type of locality.
 *
 * <p>
 *     This enum is used in the {@link LocationEntity} to
 *     specify the type of locality.
 * </p>
 *
 * <p>
 *     The locality types correspond to administrative divisions
 *     in Poland.
 * </p>
 */
public enum LocationType {

    /**
     * Voivodeship - the highest level administrative
     * division in Poland (pol. Województwo).
     */
    VOIVODESHIP,

    /**
     * County (pol. Powiat).
     */
    COUNTY,

    /**
     * Community (pol. Gmina).
     */
    COMMUNITY,

    /**
     * Town (pol. Miasto).
     */
    TOWN,

    /**
     * Village (pol. Wieś, Kolonia).
     */
    VILLAGE
}
