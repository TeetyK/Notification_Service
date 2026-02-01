package com.api.notification.service.grpc;

import com.api.notification.grpc.EmailReply;
import com.api.notification.grpc.EmailRequest;
import com.api.notification.grpc.NotificationServiceGrpc;
import com.api.notification.service.EmailService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class NotificationGrpcService extends NotificationServiceGrpc.NotificationServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(NotificationGrpcService.class);

    @Autowired
    private EmailService emailService;

    @Override
    public void sendEmail(EmailRequest request, StreamObserver<EmailReply> responseObserver) {
        log.info("Received email request for: {}", request.getTo());

        emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());

        EmailReply response = EmailReply.newBuilder()
                .setSuccess(true)
                .setMessage("Email sent successfully by Java service to " + request.getTo())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
