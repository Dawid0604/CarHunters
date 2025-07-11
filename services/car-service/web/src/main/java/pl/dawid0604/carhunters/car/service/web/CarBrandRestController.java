package pl.dawid0604.carhunters.car.service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid0604.carhunters.car.service.core.CarBrandService;

import static lombok.AccessLevel.PACKAGE;
import static pl.dawid0604.carhunters.car.service.web.Constants.API_V1;

/**
 * REST controller for managing car brands.
 *
 * <p>
 *     This controller exposes HTTP endpoints
 *     under the {@code /api/v1/car/brand} for
 *     performing operations related to car brands,
 *     such as creating, retrieving, updating, and
 *     deleting. This controller also delegates
 *     business logic to the {@link CarBrandService}.
 * </p>
 *
 * <p>
 *     Handles HTTP requests and return responses
 *     in JSON format.
 * </p>
 *
 * <p>
 *     <b>Supported HTTP methods:</b>
 *     <ul>
 *         <li>GET - retrieving a car brands</li>
 *         <li>POST - creating a car brands</li>
 *         <li>PUT - update an existing car brands</li>
 *         <li>DELETE - remove a car brands</li>
 *     </ul>
 * </p>
 */
@RestController
@RequestMapping(API_V1 + "/car/brand")
@RequiredArgsConstructor(access = PACKAGE)
class CarBrandRestController {

    /**
     * Service layer for car brands business operations.
     */
    private final CarBrandService service;
}
