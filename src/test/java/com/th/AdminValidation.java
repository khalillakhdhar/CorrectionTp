package com.th;

public class AdminValidation {
public boolean validPassword(String password,String nom)
{
if(password.contains(nom))
	return false;
else 
	return true;

}
public boolean valideNomComplet(String nom)
{
return nom.contains(" ");	
}


}
