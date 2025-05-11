package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AccountDao;
import model.Account;

@Controller
public class BankControl {
	
	@GetMapping("/enter")
 public String iniPage() {// enter into the application
	 return "mainpage";
 }
	@GetMapping("/login")
	public ModelAndView exisitingAcc(@RequestParam("pin")String pin) {// authentication if the pin entered is correct
		ModelAndView mc=new ModelAndView();
		AccountDao ac=new AccountDao();
        Account user = ac.checkPin(pin);
        if (user != null) {
        	mc.setViewName("functionPage");
        	return mc;
        } else {
            mc.setViewName("success");
            
            mc.addObject("message", "Wrong pin please add a vlaid pin");
            return mc;
        }

	}
	
	@GetMapping("/createAccountForm")// to create a new account 
	public String createAc()
	{
		return "createAcc";
	}
	
	 @GetMapping("/createAccount")
	    public ModelAndView createAccount(@RequestParam("name") String name,
	                                @RequestParam("dob") String dob,
	                                @RequestParam("address") String address,
	                                @RequestParam("pin") String pin,
	                                @RequestParam("accountType") String accountType
	                                ) {

	        Account a = new Account();
	       a.setName(name);
	        a.setDob(dob);
	        a.setAddress(address);
	        a.setPin(pin);
	        a.setAccountType(accountType);
	        AccountDao accountDao=new AccountDao();
	        // Insert data into the database using DAO
	        boolean isAccountCreated = accountDao.createAccount(a);

	        if (isAccountCreated) {
	        	ModelAndView mv=new ModelAndView("success");
	        	mv.addObject("message", "successful created account");
	           return mv; // Redirect to login page or show success message
	        } else {
	        	ModelAndView mv=new ModelAndView("error");
	        	mv.addObject("message", "THERS SOME ISSUE");
	        	return mv;// Show create account page again
	        }
	    }
	
	@GetMapping("/deposit")
    public ModelAndView deposit(@RequestParam("pin") String pin,
                          @RequestParam("amount") double amount
                          ) {
		AccountDao accountDao=new AccountDao();
        boolean success = accountDao.deposit(pin, amount);
       if(success) {
    	   ModelAndView mv=new ModelAndView("success");
       	mv.addObject("message", "Amount is deposited successfully");
    	   return mv;
       }
       ModelAndView mv=new ModelAndView("error");
   	mv.addObject("message", "Couldn't deposit money some issue");
       return mv;
    }

    // Withdraw money
    @GetMapping("/withdraw")
    public ModelAndView withdraw(@RequestParam("pin") String pin,
                           @RequestParam("amount") double amount
                           ) {
    	AccountDao accountDao=new AccountDao();
        boolean success = accountDao.withdraw(pin, amount);
        if(success) {
        	ModelAndView mv=new ModelAndView("success");
        	mv.addObject("message", "successful withdrawal");
     	   return mv;
        } else { 
        ModelAndView mv=new ModelAndView("error");
    	mv.addObject("message", "Some error in the process");
    	return mv;
    }
    }
    @GetMapping("/transfer")
    public ModelAndView transfer(@RequestParam("senderPin") String senderPin,
                                 @RequestParam("receiverPin") String receiverPin,
                                 @RequestParam("amount") double amount) {
        AccountDao accountDao = new AccountDao();
        
        boolean withdrawSuccess = accountDao.withdraw(senderPin, amount);
        if (withdrawSuccess) {
            boolean depositSuccess = accountDao.deposit(receiverPin, amount);
            if (depositSuccess) {
                ModelAndView mv = new ModelAndView("success");
                mv.addObject("message", "Transfer Successful!");
                return mv;
            } else {
                // Refund money to sender if deposit fails
                accountDao.deposit(senderPin, amount);
                ModelAndView mv = new ModelAndView("error");
                mv.addObject("message", "Transfer Failed: Could not deposit to receiver.Money is refunded successfully.");
                return mv;
            }
        } else {
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "Transfer Failed: Insufficient funds or invalid sender.");
            return mv;
        }
    }


}
