package API;

import java.util.List;

import Model.Employee;
import Model.EmployeeCUD;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Employee_API {
    //getting all employees

    @GET("employees")
    Call<List<Employee>> getEmployee();

//getting employee on the basis of employe id.
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);

    //update employee on the basis of empId
    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);

    //update employee on the basis of empid
    @PUT("update/{empID}")
    Call<Void> updateEmployee(@Path ("empID") int empId,@Body EmployeeCUD emp);

    //Delete employee on the basis of empid
    @DELETE("delete/{empID}")
    Call<Void> deleteEmployee(@Path ("empID") int empId);
}
