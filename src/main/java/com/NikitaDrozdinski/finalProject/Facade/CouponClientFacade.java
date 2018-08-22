package com.NikitaDrozdinski.finalProject.Facade;

import Exceptions.ClinetNotFoundException;

public interface CouponClientFacade {

	CouponClientFacade login(String name , String password , ClientType type) throws ClinetNotFoundException, ClassNotFoundException;
}
