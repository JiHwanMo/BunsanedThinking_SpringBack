package com.example.bunsanedthinking_springback.controller.employee;

import com.example.bunsanedthinking_springback.dto.loanManagement.CollateralDTO;
import com.example.bunsanedthinking_springback.dto.loanManagement.LoanDTO;
import com.example.bunsanedthinking_springback.entity.loan.Loan;
import com.example.bunsanedthinking_springback.entity.product.Product;
import com.example.bunsanedthinking_springback.exception.AlreadyProcessedException;
import com.example.bunsanedthinking_springback.exception.DuplicateLoanException;
import com.example.bunsanedthinking_springback.exception.NotExistContractException;
import com.example.bunsanedthinking_springback.exception.NotExistException;
import com.example.bunsanedthinking_springback.model.service.employee.loanManagement.LoanManagementSModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee/loanManagement")
public class LoanManagementController {
	@Autowired
	private LoanManagementSModel loanManagementSModel;

	@PostMapping("/addCollateralProduct")
	public void addLoanProduct(@RequestBody CollateralDTO collateralDTO) throws DuplicateLoanException {
		// loanManagementModel.addLoanProduct(loanType, name, interestRate, limit, minimumAsset, collateralType, minimumValue, monthlyPremium);
		loanManagementSModel.addLoanProduct(collateralDTO);
	}

	@PostMapping("/addLoanProduct")
	public void addLoanProduct(@RequestBody LoanDTO loanDTO) throws DuplicateLoanException {
		// loanManagementModel.addLoanProduct(loanType, name, interestRate, limit, minimumAsset, parameter, monthlyPremium);
		loanManagementSModel.addLoanProduct(loanDTO);
	}

	@GetMapping("/getLoanProduct")
	public Loan getLoanProduct(@RequestParam("id") int id) throws NotExistException {
		return loanManagementSModel.getLoanProduct(id);
	}

	public boolean collectLoanPrincipalInterest() {
		return loanManagementSModel.collectLoanPrincipalInterest();
	}

	@PostMapping("/requestLoan")
	public void requestLoan(int contractId, int money, int paymentType,
			boolean result) throws AlreadyProcessedException, NotExistContractException {
		loanManagementSModel.requestLoan(contractId, money, paymentType, result);
	}

	// public void updateLoanProduct(int index, String input, Collateral collateralLoan)
	// 		throws DuplicateLoanException, NotExistException {
	// 	loanManagementModel.updateLoanProduct(index, input, collateralLoan);
	// }

	@PatchMapping("/updateLoanProduct")
	public void updateLoanProduct(@RequestParam("index") int index, @RequestParam("input") String input,
			@RequestParam("loanId") int loanId) throws DuplicateLoanException, NotExistException {
		loanManagementSModel.updateLoanProduct(index, input, loanId);
	}

	@DeleteMapping("/deleteLoanProduct")
	public void deleteLoanProduct(@RequestParam("id") int id) throws NotExistException {
		loanManagementSModel.deleteLoanProduct(id);
	}

	@GetMapping("/getAll")
	public List<Product> getAll() {
		return loanManagementSModel.getAll();
	}

	@GetMapping("/getOutcome")
	public double getOutcome(@RequestParam("contractId") int contractId) throws
		NotExistContractException, NotExistException {
		return loanManagementSModel.getOutcome(contractId);
	}
}