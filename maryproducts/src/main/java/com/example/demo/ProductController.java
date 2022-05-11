package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/productlist/v1")
public class ProductController {

	private List<Product> productList = new ArrayList<Product>();

	@GetMapping("/getlist")
	public List<Product> getlist() {

		if (productList.size() == 0) {
			Product product1 = new Product();
			product1.setProductId("1");
			product1.setProductName("ApplePhone");
			product1.setProductDesc("Apple is best phone");
			product1.setProductPrice("100000");
			product1.setProductQuantity("30");
			product1.setProductType("Mobile");
			product1.setProductmul("new mobile");
			product1.setProductUpload("");
			product1.setChecked(false);

			Product product2 = new Product();
			product2.setProductId("2");
			product2.setProductName("1+ ");
			product2.setProductDesc("best phone");
			product2.setProductPrice("50000");
			product2.setProductQuantity("50");
			product2.setProductType("Mobile");
			product2.setProductmul("new mobile");
			product2.setProductUpload("");
			product2.setChecked(false);

			Product product3 = new Product();
			product3.setProductId("3");
			product3.setProductName("MI");
			product3.setProductDesc("MI is the best phone");
			product3.setProductPrice("80000");
			product3.setProductQuantity("40");
			product3.setProductType("Mobile");
			product3.setProductmul("new mobile");
			product3.setProductUpload("");
			product3.setChecked(false);

			Product product4 = new Product();
			product4.setProductId("4");
			product4.setProductName("Samsung");
			product4.setProductDesc("It is a Nice product");
			product4.setProductPrice("12000");
			product4.setProductQuantity("60");
			product4.setProductType("Mobile");
			product4.setProductmul("new mobile");
			product4.setProductUpload("");
			product4.setChecked(false);

			Product product5 = new Product();
			product5.setProductId("5");
			product5.setProductName("VIVO");
			product5.setProductDesc("vivo's new version");
			product5.setProductPrice("15800");
			product5.setProductQuantity("90");
			product5.setProductType("Mobile");
			product5.setProductUpload("");
			product5.setProductmul("new mobile");
			product5.setChecked(false);

			Product product6 = new Product();
			product6.setProductId("6");
			product6.setProductName("realmi");
			product6.setProductDesc("it is a best phone");
			product6.setProductPrice("19000");
			product6.setProductQuantity("10");
			product6.setProductType("Mobile");
			product6.setProductmul("new mobile");
			product6.setProductUpload("");
			product6.setChecked(false);

			Product product7 = new Product();
			product7.setProductId("7");
			product7.setProductName("Asus");
			product7.setProductDesc("Nice model");
			product7.setProductPrice("18000");
			product7.setProductQuantity("30");
			product7.setProductType("Mobile");
			product7.setProductmul("new mobile");
			product7.setProductUpload("");
			product7.setChecked(false);

			productList.add(product1);
			productList.add(product2);
			productList.add(product3);
			productList.add(product4);
			productList.add(product5);
			productList.add(product6);
			productList.add(product7);

		}

		System.out.println("2>>>>>In newlistController >>>>>>getlist()>>>>>>>>>>>>");
		return productList;
	}

	@PostMapping("/login")
	public UserBean login(@RequestBody UserBean userBean) {
		System.out.println("Start 2 In HelloWorldController::login()>>>>>>>>>>>>");
		// List<Product> productList = new ArrayList<Product>();
		if ((userBean.getUserName().equals("abc") && userBean.getUserPassword().equals("abc"))) {
			System.out.println("User is login succesful ");
			userBean.setErrorCode("200");
			// navigate to welcome screen where it shows product page with links or tabs
			return userBean;
		} else {
			System.out.println("User is login faild due to invalid credientials ");
			userBean.setErrorCode("400");
			// show same login page
			return userBean;
		}

	}

	@PostMapping("/createproduct")
	public Map<String, String> createProduct(@RequestBody List<Product> productRequest) {
		System.out.println(">>>>>productRequest--->>>>" + productRequest);
		// List<Product> productList = new ArrayList<Product>();
		System.out.println("End 2>>>>>In newlistController::createproduct()>>>>>>>>>>>>");
		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < productRequest.size(); i++) {
			Product product8 = new Product();
			product8.setProductId(productRequest.get(i).getProductId());
			product8.setProductName(productRequest.get(i).getProductName());
			product8.setProductDesc(productRequest.get(i).getProductDesc());
			product8.setProductPrice(productRequest.get(i).getProductPrice());
			product8.setProductQuantity(productRequest.get(i).getProductQuantity());
			product8.setProductType(productRequest.get(i).getProductType());
			productList.add(product8);

		}

		map.put("response", "Successfully product created");
		System.out.println("End 2>>>>>In newlistController::createproduct()>>>>>>>>>>>>");
		return map;
	}

	@PostMapping("/deleteproduct")
	public Map<String, String> deleteproduct(@RequestBody List<Product> productRequest) {
		System.out.println("Start 2>>>>>In newlistController::deleteproduct()>>>>>>>>>>>>");
		// List<Product> productList = new ArrayList<Product>();

		System.out.println("Before Size of product List" + productList.size());
		// System.out.println("productIdFromUi :: t"+productRequest.productId);

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < productRequest.size(); i++) {

			for (int j = 0; j < productList.size(); j++) {

				if (productList.get(j).getProductId().equals(productRequest.get(i).getProductId())) {
					System.out.println("Printing Product Object:: " + productList.get(i));
					productList.remove(j);
					map.put("response", "Succesfully Product Deleted");
					// break;
				} else {
					map.put("response", "Product not deleted ");
				}
				System.out.println("After Delete Size of product List" + productList.size());

				System.out.println("End 2>>>>>In Product deleted ");

			}

		}
		return map;

	}

	// single product
//	@PostMapping("/pro/{id}")
//	public product getlist(@pathVariable("id")int id) {
//		return productList.getListById(id);
//	}
//	
//	
//	@PostMapping("/pro/{proid}")
//	public List deleteproduct(@pathvariable("proid") int proId)
//	{
//		this.productList.deleteproduct(proId);
//	}

}
