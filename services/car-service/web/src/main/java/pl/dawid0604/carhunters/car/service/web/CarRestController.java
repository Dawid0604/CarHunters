package pl.dawid0604.carhunters.car.service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawid0604.carhunters.car.service.core.CarService;

import static lombok.AccessLevel.PACKAGE;
import static pl.dawid0604.carhunters.car.service.web.Constants.API_V1;

/**
 * REST controller for managing cars.
 *
 * <p>
 *     This controller exposes HTTP endpoints
 *     under the path {@code /api/v1/car} for
 *     performing operations related to cars,
 *     such as creating, retrieving, updating,
 *     and deleting. This controller delegates
 *     business logic to the {@link CarService}.
 * </p>
 *
 * <p>
 *     Handles HTTP requests and returns responses
 *     in JSON format.
 * </p>
 *
 * <p>
 *     <b>Supported HTTP methods:</b>
 *     <ul>
 *         <li>GET - retrieve cars</li>
 *         <li>POST - create a car</li>
 *         <li>PUT - update an existing car</li>
 *         <li>DELETE - remove a car</li>
 *         <li>PATCH - partially update a advertisement</li>
 *     </ul>
 * </p>
 *
 * @see RestController
 * @see RequestMapping
 * @see CarService
 */
@RestController
@RequestMapping(API_V1 + "/car")
@RequiredArgsConstructor(access = PACKAGE)
class CarRestController {

    /**
     * Service layer for car business operations.
     */
    private final CarService service;
}
