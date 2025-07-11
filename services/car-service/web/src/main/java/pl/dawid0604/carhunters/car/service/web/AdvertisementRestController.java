package pl.dawid0604.carhunters.car.service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid0604.carhunters.car.service.core.AdvertisementService;

import static lombok.AccessLevel.PACKAGE;
import static pl.dawid0604.carhunters.car.service.web.Constants.API_V1;

/**
 * REST controller for managing advertisements.
 *
 * <p>
 *     This controller exposes HTTP endpoints under the
 *     path {@code /api/v1/advertisement} for performing
 *     operations related to advertisements, such as
 *     creating, retrieving, updating, and deleting.
 *     This controller also delegates business logic
 *     to the {@link AdvertisementService}.
 * </p>
 *
 * <p>
 *     Handles HTTP requests and returns responses
 *     in JSON format.
 * </p>
 *
 * <p>
 *     <b>Supported HTTP methods</b>
 *     <ul>
 *         <li>GET - retrieve advertisements</li>
 *         <li>POST - create an advertisement</li>
 *         <li>PUT - update an existing advertisement</li>
 *         <li>DELETE - remove an advertisement</li>
 *         <li>PATCH - partially update an advertisement</li>
 *     </ul>
 * </p>
 *
 * @see RestController
 * @see RequestMapping
 * @see AdvertisementService
 */
@RestController
@RequestMapping(API_V1 + "/advertisement")
@RequiredArgsConstructor(access = PACKAGE)
class AdvertisementRestController {

    /**
     * Service layer for advertisement business operations.
     */
    private final AdvertisementService service;
}
