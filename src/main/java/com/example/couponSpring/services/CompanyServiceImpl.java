package com.example.couponSpring.services;

import com.example.couponSpring.beans.Category;
import com.example.couponSpring.beans.Company;
import com.example.couponSpring.beans.Coupon;
import com.example.couponSpring.exceptions.ErrorMessage;
import com.example.couponSpring.exceptions.SystemException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CompanyServiceImpl extends ClientService implements CompanyService {
    private Company company;


    public CompanyServiceImpl(Company company) {
        this.company = company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public Coupon addCoupon(Coupon coupon) throws SystemException {
        if (couponRepository.existsByCompanyAndTitle(company, coupon.getTitle())){
            throw new SystemException(ErrorMessage.COUPON_ALREADY_EXISTS);
        }
        coupon.setCompany(company);
        return couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws SystemException {
        coupon.setCompany(company);
        if (!couponRepository.existsByIdAndCompany(coupon.getId(), coupon.getCompany())){
            throw new SystemException(ErrorMessage.COUPON_NOT_ALLOWED_UPDATE_COUPON_OR_COMPANY_CODE);
        }
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws SystemException {
        if (!couponRepository.existsByIdAndCompany(couponId, company)){
            throw new SystemException(ErrorMessage.COUPON_NOT_EXISTS);
        }
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getCompanyCoupons() throws SystemException {
        if (!couponRepository.existsByCompany(company)) {
            throw new SystemException(ErrorMessage.COUPON_NOT_EXISTS);
        }
        return couponRepository.findByCompany(company);
    }

    @Override
    public List<Coupon> getCompanyCouponsByCategory(Category category) throws SystemException {
        if (!couponRepository.existsByCompany(company)){
            throw new SystemException(ErrorMessage.COUPON_NOT_EXISTS);
        }
        return couponRepository.findByCompanyAndCategory(company, category);
    }

    @Override
    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) throws SystemException {
        if (!couponRepository.existsByCompany(company)){
            throw new SystemException(ErrorMessage.COUPON_NOT_EXISTS);
        }
        return couponRepository.findByCompanyAndPriceGreaterThanEqual(company, maxPrice);
    }

    @Override
    public Company getCompanyDetails() throws SystemException {
        return companyRepository.findById(company.getId()).orElseThrow(() -> new SystemException(ErrorMessage.COMPANY_NOT_EXISTS));
    }

    @Override
    public Coupon getOneCoupon(int couponId) throws SystemException {
        if (!couponRepository.existsByIdAndCompany(couponId, company)){
            throw new SystemException(ErrorMessage.COUPON_NOT_EXISTS);
        }
        return couponRepository.findById(couponId).orElseThrow(() -> new SystemException(ErrorMessage.COUPON_NOT_EXISTS));
    }

    @Override
    public Company getCompanyByEmail(String email) throws SystemException {
        return companyRepository.findByEmail(email).orElseThrow(() -> new SystemException(ErrorMessage.COMPANY_NOT_EXISTS));
    }

}
