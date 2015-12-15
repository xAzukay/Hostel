<%@ include file="../layouts/header.jsp" %>

<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="../login" role="login">
          <!--<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />-->
          <h1 align="center">Hostel</h1>
          <input type="text" name="matric_no" placeholder="Name" required class="form-control input-lg" value="" required="required" />
          <input type="text" name="matric_no" placeholder="Matric No" required class="form-control input-lg" value="" required="required" />
          
          <input type="text" name="ic_no" placeholder="IC No" class="form-control input-lg" id="password" required="required" />
          
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Log in</button>
          <div>
            <a href="login.jsp">Back</a>
          </div>
          
        </form>
        
        <div class="form-links">
          <a href="../../index.jsp">Index</a>
        </div>
      </section>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
</div>

<%@ include file="../layouts/footer.jsp" %>