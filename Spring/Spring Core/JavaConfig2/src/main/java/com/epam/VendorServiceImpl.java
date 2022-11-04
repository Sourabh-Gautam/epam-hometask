package com.epam;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service(value = "vendorService")
public class VendorServiceImpl implements CustomerService{
	@Override
	public List<Vendor> getContractors() {
		return Arrays.asList(new Vendor("komal","java"),new Vendor("sneka","sql"));
	}
}
