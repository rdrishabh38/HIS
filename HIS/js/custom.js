$(document).ready(function(){
    //alert("hi");
	$(".formSubmit").click(function(){
		var id = $(this).val();
		var amount = $("#pAmount"+id).val();
		var duration = $("#pDuration"+id).val();
		var type = $("#pType"+id).val();
		//alert(id+amount+duration+type);
		//alert(id);
		$.ajax({
			url: "EditPolicyServlet",
			method: "POST",
			data: { pid: id, pAmount: amount, pDuration:duration, pType:type },
			success: function(result){
				//$("#div1").html(result);
				//alert(result);
				$("#updatemsg").replaceWith(result);
			}
		});
	});
	
	$(".getPolicyDetail").click(function (){
		
		
		var id = $(this).val();
		$.ajax({
			url: "AdminViewPolicyServlet",
			method: "POST",
			data: { pid: id },
			success: function(result){
				//alert(result);
				var arr=result.split("_");
				$("#tPolicyId").html(arr[0]);
				$("#tInsName").html(arr[1]);
				$("#tPolicyAmount").html(arr[2]);
				$("#tPolicyDuration").html(arr[3]);
				$("#tPremiumType").html(arr[4]);
				$("#tDiscount").html(arr[5]);
				$("#tPremiumAmount").html(arr[6]);
				$("#tPolicyStartDate").html(arr[7]);
				$("#tPolicyMaturityDate").html(arr[8]);
				$("#tStatus").html(arr[9]);
				$("#tRejectButton").val(arr[0]);
				$("#tApproveButton").val(arr[0]);
				$(".updatebutton").removeAttr('disabled');
			}
		});
	});
	
	$("#tApproveButton").click(function (){
		var pid=$(this).val();
		
		$.ajax({
			url: "AdminViewPolicyServlet",
			method: "POST",
			data: { pid: pid, status:"approve"},
			success: function(result){
				if(result == "")
					alert("approved successful");
				else
					alert(result);
				location.reload();
			}
		});
	});
	
	$("#tRejectButton").click(function (){
		
		var pid=$(this).val();
		
		$.ajax({
			url: "AdminViewPolicyServlet",
			method: "POST",
			data: { pid: pid, status:"reject"},
			success: function(result){
				if(result == "")
					alert("rejected successful");
				else
					alert(result);
				location.reload();
			}
		});
		
	});
	
	$(".getPolicyDetailClaim").click(function (){
		var pid = $(this).val();
		var cType;
		$.ajax({
			url : "RequestClaimServlet",
			method : "post",
			data : {pid: pid},
			success : function (result){
				var arr = result.split("_");
				$("#tPolicyId").html(arr[0]);
				$("#tInsName").html(arr[1]);
				$("#tPolicyAmount").html(arr[2]);
				$("#tPolicyDuration").html(arr[3]);
				$("#tPremiumType").html(arr[4]);
				$("#tDiscount").html(arr[5]);
				$("#tPremiumAmount").html(arr[6]);
				$("#tPolicyStartDate").html(arr[7]);
				$("#tPolicyMaturityDate").html(arr[8]);
				$("#tClaimButton").val(arr[0]);
				$("#tClaimButton").removeAttr('disabled');
			}
		});
	});
	
	$("#tClaimButton").click(function (){
		var pid=$(this).val();
		var cType=$("#ClaimType").val();
		$.ajax({
			url: "RequestClaimServlet",
			method: "POST",
			data:{pid:pid , claimType:cType},
			success:function(result){
				alert(result);
			}
		});
	});
	
});
