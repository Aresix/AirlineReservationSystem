package myInterface;

import myClass.Customer;

public interface ISubject {

    public void AttachCustomer(Customer customer);

    public void DetachCustomer(Customer customer);

    public void notifyCustomer();
}
