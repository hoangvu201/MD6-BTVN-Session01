package ra.btvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn.model.dto.respone.ApiDataResponse;
import ra.btvn.model.entity.BorrowDetail;
import ra.btvn.service.BorrowDetailService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/borrow-details")
public class BorrowDetailController {
    @Autowired
    private BorrowDetailService borrowDetailService;

    @PostMapping
    public ResponseEntity<ApiDataResponse<BorrowDetail>> createBorrowDetail(
            @RequestBody BorrowDetail borrowDetail,
            @RequestParam Long borrowId,
            @RequestParam Long bookId,
            @RequestParam Integer quantity) {
    BorrowDetail created = borrowDetailService.createBorrowDetail(borrowDetail,borrowId,bookId,quantity);

    return new ResponseEntity<>(new ApiDataResponse<>(
            true,
            "Created borrow detail",
            created,
            null,
            HttpStatus.CREATED
    ), HttpStatus.CREATED);
    }

    @GetMapping("/by-borrow")
    public ResponseEntity<ApiDataResponse<List<BorrowDetail>>> getBorrowDetailByBorrowId(@RequestParam Long borrowId) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get borrow details successfully",
                borrowDetailService.getBorrowDetailsByBorrowId(borrowId),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }
}
