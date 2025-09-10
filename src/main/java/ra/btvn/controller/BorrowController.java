package ra.btvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn.model.dto.respone.ApiDataResponse;
import ra.btvn.model.entity.Borrow;
import ra.btvn.service.BorrowService;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Borrow>>> getAllBorrows(){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get all borrows successfully!",
                borrowService.getAllBorrows(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Borrow>> createBorrow(@RequestParam Long memberId ,@RequestBody Borrow borrow){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Borrow created successfully!",
                borrowService.createBorrow(borrow,memberId),
                null,
                HttpStatus.CREATED
        ),HttpStatus.CREATED);
    }
}
