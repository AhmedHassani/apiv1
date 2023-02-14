package com.iraqsofit.speedoo.repository;

import com.iraqsofit.speedoo.models.NotificationModel;
import com.iraqsofit.speedoo.models.ProductsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {

}
