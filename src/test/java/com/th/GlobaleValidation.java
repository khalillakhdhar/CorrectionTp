package com.th;

public class GlobaleValidation {
public boolean conversible(String nombre)
{
try
{
Integer.parseInt(nombre);
return true;
}
catch (Exception e) {
	// TODO: handle exception
	return false;
}
}
public boolean verifEmpty(String ch)
{
	return ch.isEmpty();
}


}
