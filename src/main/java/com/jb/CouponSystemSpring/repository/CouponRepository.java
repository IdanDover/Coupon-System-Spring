package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Coupon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCompanyId(int companyId);

    boolean existsByCompanyIdAndTitle(int companyId, String title);

    boolean existsByIdAndEndDateBefore(int couponId, LocalDate today);

    @Query(value = "SELECT EXISTS(SELECT * FROM `coupon-system-spring`.coupons" +
            " WHERE `id`=? AND `amount`<=0 )", nativeQuery = true)
    Long couponOutOfStock(int couponId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `coupon-system-spring`.coupons c SET c.amount = c.amount - 1 WHERE c.id = ?", nativeQuery = true)
    void reduceAmountById(int couponId);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Coupon c WHERE c.endDate < :expiryDate")
    void deleteExpiredCoupons(@Param("expiryDate") Date expiryDate);

}
