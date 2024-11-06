package com.example.bunsanedthinking_springback.controller.employee;

import com.example.bunsanedthinking_springback.entity.contract.Contract;
import com.example.bunsanedthinking_springback.entity.customer.Customer;
import com.example.bunsanedthinking_springback.entity.endorsment.Endorsement;
import com.example.bunsanedthinking_springback.entity.recontract.Recontract;
import com.example.bunsanedthinking_springback.entity.revival.Revival;
import com.example.bunsanedthinking_springback.entity.termination.Termination;
import com.example.bunsanedthinking_springback.exception.AlreadyProcessedException;
import com.example.bunsanedthinking_springback.exception.NotExistContractException;
import com.example.bunsanedthinking_springback.exception.NotExistException;
import com.example.bunsanedthinking_springback.model.service.employee.contractManagement.ContractManagementSModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/contractManagement")
public class ContractManagementController {
	@Autowired
	private ContractManagementSModel contractManagementSModel;

//	public boolean requestTerminationFee(Termination tercontract, Customer customer,
//										 PaymentDetailList paymentDetailList, ContractList contractList) throws NotExistContractException, AlreadyProcessedException {
//		return contractManagementModel.requestTerminationFee(tercontract, customer, paymentDetailList, contractList);
//	}
//	public boolean reviewEndorsement(Endorsement encontract, Customer customer, int index) {
//		return contractManagementModel.reviewEndorsement(encontract, customer, index);
//	}
//
//	public boolean reviewRecontract(ContractList contractList, Recontract recontract, Customer customer, int index) throws NotExistContractException {
//		return contractManagementModel.reviewRecontract(contractList, recontract, customer, index);
//	}
//
//	public boolean reviewRevival(ContractList contractList, Revival revivalcontract, Customer customer, int index) {
//		return contractManagementModel.reviewRevival(contractList, revivalcontract, customer, index);
//	}
//	public ArrayList<Contract> getAllDefaultContract(ContractList contractList) {
//		return contractManagementModel.getAllDefaultContract(contractList);
//	}
//	public Customer getCustomerById(CustomerList customerList, Contract contract) throws NotExistException {
//		return contractManagementModel.getCustomerById(customerList, contract);
//	}
//
//	public Contract getContractById(ContractList contractList, int id) throws NotExistContractException {
//		return contractManagementModel.getContractById(contractList, id);
//	}
//	public Termination getTerminationById(TerminationList terminationList, int id) {
//		return contractManagementModel.getTerminationById(terminationList, id);
//	}
//	public ArrayList<Termination> getAllTerminatingContract(TerminationList terminationList) {
//		return contractManagementModel.getAllTerminatingContract(terminationList);
//	}
//	public Termination getTerminatingContractById(TerminationList terminationList,int id) {
//		return contractManagementModel.getTerminatingContractById(terminationList, id);
//	}
//	public ArrayList<Termination> getAllUnprocessedTerminatingContract(TerminationList terminationList) {
//		return contractManagementModel.getAllUnprocessedTerminatingContract(terminationList);
//	}
//	public ArrayList<Termination> getAllProcessedTerminatingContract(TerminationList terminationList) {
//		return contractManagementModel.getAllProcessedTerminatingContract(terminationList);
//	}
//	public ArrayList<Endorsement> getAllEndorsementContract(EndorsementList endorsementList) {
//		return contractManagementModel.getAllEndorsementContract(endorsementList);
//	}
//	public ArrayList<Endorsement> getAllUnprocessedEndorsementContract(EndorsementList endorsementList) {
//		return contractManagementModel.getAllUnprocessedEndorsementContract(endorsementList);
//	}
//	public ArrayList<Endorsement> getAllProcessedEndorsementContract(EndorsementList endorsementList) {
//		return contractManagementModel.getAllProcessedEndorsementContract(endorsementList);
//	}
//	public Endorsement getEndorsementById(EndorsementList endorsementList, int id) {
//		return contractManagementModel.getEndorsementById(endorsementList, id);
//	}
//	public ArrayList<Recontract> getAllReContract(RecontractList recontractList) {
//		return contractManagementModel.getAllReContract(recontractList);
//	}
//
//	public ArrayList<Recontract> getAllUnprocessedReContract(RecontractList recontractList) {
//		return contractManagementModel.getAllUnprocessedReContract(recontractList);
//	}
//
//	public ArrayList<Recontract> getAllProcessedReContract(RecontractList recontractList) {
//		return contractManagementModel.getAllProcessedReContract(recontractList);
//	}
//
//	public Recontract getReContractById(RecontractList recontractList, int id) {
//		return contractManagementModel.getReContractById(recontractList, id);
//	}
//
//	public ArrayList<Revival> getAllRevivalContract(RevivalList revivalList) {
//		return contractManagementModel.getAllRevivalContract(revivalList);
//	}
//	public ArrayList<Revival> getAllRevivalContract(RevivalList revivalList) {
//		return contractManagementModel.getAllRevivalContract(revivalList);
//	}
//
//	public Revival getRevivalById(RevivalList revivalList, int id) {
//		return contractManagementModel.getRevivalById(revivalList, id);
//	}
//
//	public ArrayList<Revival> getAllUnprocessedRevival(RevivalList revivalList) {
//		return contractManagementModel.getAllUnprocessedRevival(revivalList);
//	}
//
//	public ArrayList<Revival> getAllProcessedRevival(RevivalList revivalList) {
//		return contractManagementModel.getAllProcessedRevival(revivalList);
//	}
	@PatchMapping("/requestTerminationFee")
	public void requestTerminationFee(@RequestParam int tercontractId, @RequestParam int customerId)
            throws NotExistContractException, AlreadyProcessedException, NotExistException {
		// 예시URL - http://localhost:8080/employee/contractManagement/requestTerminationFee?tercontractId=1002&customerId=2002
		contractManagementSModel.requestTerminationFee(tercontractId, customerId);
	}
	@PatchMapping("/reviewEndorsement")
	public void reviewEndorsement(@RequestParam int endorsementId, @RequestParam int index) throws NotExistException {
		// 예시URL - http://localhost:8080/employee/contractManagement/reviewEndorsement?endorsementId=1002&index=1
		contractManagementSModel.reviewEndorsement(endorsementId, index);
	}
	@PatchMapping("/reviewRecontract")
	public void reviewRecontract(@RequestParam int recontractId, @RequestParam int index) throws NotExistContractException, NotExistException {
		// 예시URL - http://localhost:8080/employee/contractManagement/reviewRecontract?recontractId=1001&index=1
		contractManagementSModel.reviewRecontract(recontractId, index);
	}
	@PatchMapping("/reviewRevival")
	public void reviewRevival(@RequestParam int revivalId, @RequestParam int index) throws NotExistContractException {
		// 예시URL - http://localhost:8080/employee/contractManagement/reviewRevival?revivalId=1001&index=1
		contractManagementSModel.reviewRevival(revivalId, index);
	}

	@GetMapping("/getAllDefaultContract")
	public List<Contract> getAllDefaultContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllDefaultContract();
	}
	@GetMapping("/getCustomerById")
	public Customer getCustomerById(@RequestParam int id) throws NotExistException, NotExistContractException {
		return contractManagementSModel.getCustomerById(id);
	}
	@GetMapping("/getContractById")
	public Contract getContractById(@RequestParam int id) throws NotExistContractException, NotExistException {
		return contractManagementSModel.getContractById(id);
	}
	@GetMapping("/getTerminationById")
	public Termination getTerminationById(@RequestParam int id) throws NotExistContractException, NotExistException {
		return contractManagementSModel.getTerminationById(id);
	}
	@GetMapping("/getAllTerminatingContract")
	public List<Termination> getAllTerminatingContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllTerminatingContract();
	}
	@GetMapping("/getTerminatingContractById")
	public Termination getTerminatingContractById(@RequestParam int id) throws NotExistContractException, NotExistException {
		// ## getTerminationById랑 중복!!
		return contractManagementSModel.getTerminatingContractById(id);
	}
	@GetMapping("/getAllUnprocessedTerminatingContract")
	public List<Termination> getAllUnprocessedTerminatingContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllUnprocessedTerminatingContract();
	}
	@GetMapping("/getAllProcessedTerminatingContract")
	public List<Termination> getAllProcessedTerminatingContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllProcessedTerminatingContract();
	}
	@GetMapping("/getAllEndorsementContract")
	public List<Endorsement> getAllEndorsementContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllEndorsementContract();
	}
	@GetMapping("/getAllUnprocessedEndorsementContract")
	public List<Endorsement> getAllUnprocessedEndorsementContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllUnprocessedEndorsementContract();
	}
	@GetMapping("/getAllProcessedEndorsementContract")
	public List<Endorsement> getAllProcessedEndorsementContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllProcessedEndorsementContract();
	}
	@GetMapping("/getEndorsementById")
	public Endorsement getEndorsementById(@RequestParam int id) throws NotExistContractException, NotExistException {
		return contractManagementSModel.getEndorsementById(id);
	}
	@GetMapping("/getAllReContract")
	public List<Recontract> getAllReContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllReContract();
	}
	@GetMapping("/getAllUnprocessedReContract")
	public List<Recontract> getAllUnprocessedReContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllUnprocessedReContract();
	}
	@GetMapping("/getAllProcessedReContract")
	public List<Recontract> getAllProcessedReContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllProcessedReContract();
	}
	@GetMapping("/getReContractById")
	public Recontract getReContractById(@RequestParam int id) throws NotExistContractException, NotExistException {
		return contractManagementSModel.getReContractById(id);
	}
	@GetMapping("/getAllRevivalContract")
	public List<Revival> getAllRevivalContract() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllRevivalContract();
	}
	@GetMapping("/getRevivalById")
	public Revival getRevivalById(@RequestParam int id) throws NotExistContractException, NotExistException {
		return contractManagementSModel.getRevivalById(id);
	}
	@GetMapping("/getAllUnprocessedRevival")
	public List<Revival> getAllUnprocessedRevival() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllUnprocessedRevival();
	}
	@GetMapping("/getAllProcessedRevival")
	public List<Revival> getAllProcessedRevival() throws NotExistContractException, NotExistException {
		return contractManagementSModel.getAllProcessedRevival();
	}
	// 아래는 지운 메소드 - 기능 중복 고려
//	public Recontract get(RecontractList recontractList, int id) {
//		return contractManagementModel.getRecontractById(recontractList, id);
//	}

//	public Revival get(RevivalList revivalList, int id) {
//		return contractManagementModel.get(revivalList, id);
//	}
}