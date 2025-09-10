package ra.btvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn.model.dto.request.MemberDTO;
import ra.btvn.model.dto.respone.ApiDataResponse;
import ra.btvn.model.entity.Member;
import ra.btvn.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Member>>> getAllMembers() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Get list members successfully!",
                memberService.getAllMembers(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Member>> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Created member successfully!",
                memberService.createMember(member),
                null,
                HttpStatus.CREATED
        ),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Member>> updateMember(@PathVariable Long id, @RequestBody Member member) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Update member successfully!",
                memberService.updateMember(id, member),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Member>> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Delete member successfully!",
                null,
                null,
                HttpStatus.NO_CONTENT
        ),HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Member>> patchMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Update member successfully!",
                memberService.updateMember1(id, memberDTO),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }
}
