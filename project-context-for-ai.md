# Contexte Complet du Projet

**Projet:** payment-service  
**Date de génération:** 19/03/2026 22:53:48  
**Chemin:** D:\Projets\Scolaire\Reseau\Litige\payment-service

---

## Table des matières
1. [Structure du projet](#structure-du-projet)
2. [Contenu des fichiers](#contenu-des-fichiers)
3. [Statistiques](#statistiques)

---

## Structure du projet

```
├── .github
│   └── workflows
│       └── ci-cd.yml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── yowyob
│   │   │           └── template
│   │   │               ├── application
│   │   │               │   └── service
│   │   │               │       ├── TransactionService.java
│   │   │               │       └── WalletService.java
│   │   │               ├── domain
│   │   │               │   ├── exception
│   │   │               │   │   ├── StockFullException.java
│   │   │               │   │   ├── TransactionNotFoundException.java
│   │   │               │   │   └── WalletNotFoundException.java
│   │   │               │   ├── handler
│   │   │               │   │   ├── AbstractTransactionHandler.java
│   │   │               │   │   ├── PaymentHandler.java
│   │   │               │   │   └── RechargeHandler.java
│   │   │               │   ├── model
│   │   │               │   │   ├── Transaction.java
│   │   │               │   │   ├── TransactionStatus.java
│   │   │               │   │   ├── TransactionType.java
│   │   │               │   │   └── Wallet.java
│   │   │               │   └── ports
│   │   │               │       ├── in
│   │   │               │       │   ├── TransactionUseCase.java
│   │   │               │       │   └── WalletUseCase.java
│   │   │               │       └── out
│   │   │               │           ├── TransactionRepositoryPort.java
│   │   │               │           ├── WalletCachePort.java
│   │   │               │           ├── WalletEventPublisherPort.java
│   │   │               │           └── WalletRepositoryPort.java
│   │   │               ├── infrastructure
│   │   │               │   ├── adapters
│   │   │               │   │   ├── inbound
│   │   │               │   │   │   ├── kafka
│   │   │               │   │   │   │   ├── event
│   │   │               │   │   │   │   │   ├── PaymentCommissionEvent.java
│   │   │               │   │   │   │   │   └── WalletCreationEvent.java
│   │   │               │   │   │   │   ├── KafkaPaymentConsumer.java
│   │   │               │   │   │   │   └── WalletEventConsumer.java
│   │   │               │   │   │   └── rest
│   │   │               │   │   │       ├── dto
│   │   │               │   │   │       │   ├── TransactionRequest.java
│   │   │               │   │   │       │   ├── TransactionResponse.java
│   │   │               │   │   │       │   ├── WalletRequest.java
│   │   │               │   │   │       │   └── WalletResponse.java
│   │   │               │   │   │       ├── GlobalExceptionHandler.java
│   │   │               │   │   │       ├── TransactionController.java
│   │   │               │   │   │       └── WalletController.java
│   │   │               │   │   └── outbound
│   │   │               │   │       ├── cache
│   │   │               │   │       │   └── RedisAdapter.java
│   │   │               │   │       ├── messaging
│   │   │               │   │       │   └── KafkaAdapter.java
│   │   │               │   │       └── persistence
│   │   │               │   │           ├── entity
│   │   │               │   │           │   ├── TransactionEntity.java
│   │   │               │   │           │   └── WalletEntity.java
│   │   │               │   │           ├── repository
│   │   │               │   │           │   ├── TransactionR2dbcRepository.java
│   │   │               │   │           │   └── WalletR2dbcRepository.java
│   │   │               │   │           ├── PostgresTransactionAdapter.java
│   │   │               │   │           └── PostgresWalletAdapter.java
│   │   │               │   ├── config
│   │   │               │   │   ├── KafkaConfig.java
│   │   │               │   │   ├── OpenApiConfig.java
│   │   │               │   │   ├── RedisConfig.java
│   │   │               │   │   ├── SecurityConfig.java
│   │   │               │   │   └── WebClientConfig.java
│   │   │               │   └── mappers
│   │   │               │       ├── TransactionMapper.java
│   │   │               │       └── WalletMapper.java
│   │   │               └── PaymentServiceApplication.java
│   │   └── resources
│   │       ├── db
│   │       │   └── changelog
│   │       │       ├── changes
│   │       │       │   └── v1.0-create-initial-schema.xml
│   │       │       └── db.changelog-master.xml
│   │       ├── application.yml
│   │       ├── prod.application.yml
│   │       └── schema.sql
│   └── test
│       └── java
│           └── com
│               └── yowyob
│                   └── template
│                       └── PaymentServiceApplicationTests.java
├── .gitattributes
├── .gitignore
├── compose.yaml
├── Dockerfile
├── generate.js
├── mvnw
├── mvnw.cmd
└── pom.xml
```

---

## Contenu des fichiers

### 📄 .github\workflows\ci-cd.yml

```yaml
name: Spring Boot CI/CD

on:
  push:
    branches:
      - "**"
jobs:
  pipeline:
    uses: projet-synthese-gi26/workflows/.github/workflows/spring-boot-ci-cd.yml@main
    with:
      app_name: payment-service
    secrets: inherit          # passe TOUS les secrets automatiquement
```

*Lignes: 12*

---

### 📄 compose.yaml

```yaml

```

*Lignes: 1*

---

### 📄 pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.6</version>
        <relativePath/>
    </parent>
    
    <groupId>com.yowyob</groupId>
    <artifactId>payment-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>reactive-hexagonal</name>
    <description>api de paiement </description>
    
    <properties>
        <java.version>21</java.version>
        <spring-cloud.version>2023.0.0</spring-cloud.version>
        <mapstruct.version>1.5.5.Final</mapstruct.version>
    </properties>
    
    <dependencies>
        <!-- REACTIVE CORE -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
        <!-- DATA (R2DBC & REDIS) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-r2dbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>r2dbc-postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!-- LIQUIBASE (Migration DB) -->
        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-core</artifactId>
        </dependency>
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
		</dependency>
        <!-- MESSAGING (KAFKA) -->
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>io.projectreactor.kafka</groupId>
            <artifactId>reactor-kafka</artifactId>
            <version>1.3.22</version>
        </dependency>

        <!-- CLOUD & RESILIENCE -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-circuitbreaker-reactor-resilience4j</artifactId>
        </dependency>

        <!-- TOOLS (Lombok & Mapstruct) -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>${mapstruct.version}</version>
        </dependency>
        
        <!-- Docker Compose Auto-setup -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-docker-compose</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <!-- SECURITY RESOURCE SERVER -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        
        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
			<groupId>org.springdoc</groupId>
			            <artifactId>springdoc-openapi-starter-webflux-ui</artifactId>
			            <version>2.5.0</version>		</dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>1.18.30</version>
                        </path>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                            <version>${mapstruct.version}</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                            <version>0.2.0</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

```

*Lignes: 184*

---

### 📄 src\main\java\com\yowyob\template\application\service\TransactionService.java

```java
package com.yowyob.template.application.service;

import com.yowyob.template.domain.exception.TransactionNotFoundException;
import com.yowyob.template.domain.exception.WalletNotFoundException;
import com.yowyob.template.domain.handler.AbstractTransactionHandler;
import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.TransactionUseCase;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransactionService implements TransactionUseCase {

    private final Map<TransactionType, AbstractTransactionHandler> handlersMap;
    private final TransactionRepositoryPort transactionRepositoryPort;
    private final WalletRepositoryPort walletRepositoryPort;

    public TransactionService(List<AbstractTransactionHandler> handlers, TransactionRepositoryPort transactionRepositoryPort, WalletRepositoryPort walletRepositoryPort) {
        this.handlersMap = handlers.stream()
                .collect(Collectors.toMap(AbstractTransactionHandler::getTransactionType, Function.identity()));
        this.transactionRepositoryPort = transactionRepositoryPort;
        this.walletRepositoryPort = walletRepositoryPort;
    }


    @Override
    public Mono<Transaction> createTransaction(Transaction transaction) {
        AbstractTransactionHandler handler = handlersMap.get(transaction.type());
        if (handler == null) {
            return Mono.error(new IllegalArgumentException("Type de transaction inconnu : " + transaction.type()));
        }
        return handler.process(transaction.walletId(), transaction.amount());
    }

    @Override
    public Mono<Transaction> getTransactionById(UUID id) {
        return transactionRepositoryPort.getTransactionById(id)
                .switchIfEmpty(Mono.error(new TransactionNotFoundException("Transaction not found")));
    }

    @Override
    public Flux<Transaction> getTransactionsByWalletId(UUID walletId) {
        return walletRepositoryPort.findById(walletId)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Not found")))
                .flatMapMany(wallet -> transactionRepositoryPort.getTransactionsByWalletId(walletId));
    }
}

```

*Lignes: 60*

---

### 📄 src\main\java\com\yowyob\template\application\service\WalletService.java

```java
package com.yowyob.template.application.service;


import com.yowyob.template.domain.exception.WalletNotFoundException;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.domain.ports.out.WalletEventPublisherPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService implements WalletUseCase {

    public  final WalletRepositoryPort walletRepositoryPort;
    private final WalletEventPublisherPort eventPublisher;

    @Override
    public Mono<Wallet> createWallet(Wallet wallet) {
        Wallet toSave = new Wallet(
                wallet.id() != null ? wallet.id() : UUID.randomUUID(), // Génération ID si absent
                wallet.ownerId(),
                wallet.ownerName(),
                wallet.balance() != null ? wallet.balance() : BigDecimal.valueOf(1000)
        );

        return walletRepositoryPort.save(toSave);
                //.flatMap(saved -> eventPublisher.publishWalletCreated(saved).thenReturn(saved));
    }

    @Override
    public Mono<Wallet> getWalletByOwnerId(UUID ownerId) {
        return walletRepositoryPort.findByOwnerId(ownerId)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Wallet not found")));
    }

    @Override
    public Mono<Wallet> updateWallet(Wallet wallet) {
        return walletRepositoryPort.findById(wallet.id())
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Wallet not found")))
                .flatMap(existingWallet -> {
                    Wallet walletToUpdate = new Wallet(
                            existingWallet.id(),
                            wallet.ownerId() == null? existingWallet.ownerId(): wallet.ownerId(),
                            wallet.ownerName() == null? existingWallet.ownerName(): wallet.ownerName(),
                            existingWallet.balance()
                    );

                    return walletRepositoryPort.updateWallet(walletToUpdate);
                });
    }

    @Override
    public Mono<Void> deleteWallet(UUID id) {
        return walletRepositoryPort.findById(id)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Wallet not found")))
                .flatMap(wallet -> walletRepositoryPort.deleteById(wallet.id()));
    }

    @Override
    public Mono<Wallet> getWalletById(UUID id) {
        return walletRepositoryPort.findById(id)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Not found")));
    }

    @Override
    public Flux <Wallet> getAllWallets() {
        return walletRepositoryPort.findAllWallets();
    }
}

```

*Lignes: 76*

---

### 📄 src\main\java\com\yowyob\template\domain\exception\StockFullException.java

```java
package com.yowyob.template.domain.exception;

public class StockFullException extends RuntimeException {
    public StockFullException(String message) {
        super(message);
    }
}
```

*Lignes: 7*

---

### 📄 src\main\java\com\yowyob\template\domain\exception\TransactionNotFoundException.java

```java
package com.yowyob.template.domain.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}

```

*Lignes: 8*

---

### 📄 src\main\java\com\yowyob\template\domain\exception\WalletNotFoundException.java

```java
package com.yowyob.template.domain.exception;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String message) {
        super(message);
    }
}

```

*Lignes: 8*

---

### 📄 src\main\java\com\yowyob\template\domain\handler\AbstractTransactionHandler.java

```java
package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class AbstractTransactionHandler {

    protected final WalletRepositoryPort walletRepository;
    protected final TransactionRepositoryPort transactionRepository;

    public abstract TransactionType getTransactionType();

    // LE TEMPLATE METHOD (Orchestration Reactive)
    public Mono<Transaction> process(UUID walletId, BigDecimal amount) {
        TransactionType type = getTransactionType();
        return walletRepository.findById(walletId)
                .switchIfEmpty(Mono.error(new RuntimeException("Wallet not found")))
                .flatMap(wallet -> validate(wallet, amount)) // Etape 1 : Validation
                .flatMap(wallet -> applyBalance(wallet, amount)) // Etape 2 : Calcul nouveau solde
                .flatMap(walletRepository::updateWallet)
                .flatMap(savedWallet -> createTransaction(savedWallet, amount, type)) // Etape 4 : Créer objet Transaction
                .flatMap(transactionRepository::save) // Etape 5 : Sauvegarder historique
                .doOnSuccess(this::publishEvent); // Etape 6 : Side effect (Event)
    }

    // Méthodes abstraites à implémenter par les enfants
    protected abstract Mono<Wallet> validate(Wallet wallet, BigDecimal amount);
    protected abstract Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount);

    // Méthode commune
    private Mono<Transaction> createTransaction(Wallet wallet, BigDecimal amount, TransactionType type) {
        return Mono.just(new Transaction(null, wallet.id(), amount, type, TransactionStatus.COMPLETED));
    }

    // Méthode commune (peut être override ou déléguer à un port)
    protected void publishEvent(Transaction tx) {
        // Ici tu appelleras ton KafkaPort si besoin
        System.out.println("EVENT PUBLISHED: " + tx);
    }
}
```

*Lignes: 49*

---

### 📄 src\main\java\com\yowyob\template\domain\handler\PaymentHandler.java

```java
package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;

@Component
public class PaymentHandler extends AbstractTransactionHandler {

    private BigDecimal amountToRemove = new BigDecimal(0);

    public PaymentHandler(WalletRepositoryPort walletRepo, TransactionRepositoryPort txRepo) {
        super(walletRepo, txRepo);
    }

    @Override
    protected Mono<Wallet> validate(Wallet wallet, BigDecimal amount) {
        // Sécurité : On ne peut pas "payer" un montant négatif ou nul
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new IllegalArgumentException("Le montant du paiement doit être positif"));
        }

        // Sécurité : Solde insuffisant
        amountToRemove = ( amount.multiply(BigDecimal.valueOf(10)) ).divide(BigDecimal.valueOf(100));
        if (wallet.balance().compareTo(amountToRemove) < 0) {
            return Mono.error(new RuntimeException("Solde insuffisant pour le paiement"));
        }
        return Mono.just(wallet);
    }

    @Override
    protected Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount) {
        return Mono.just(wallet.withBalance(wallet.balance().subtract(amountToRemove)));
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.PAYMENT;
    }
}
```

*Lignes: 44*

---

### 📄 src\main\java\com\yowyob\template\domain\handler\RechargeHandler.java

```java
package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
public class RechargeHandler extends AbstractTransactionHandler {

    public RechargeHandler(WalletRepositoryPort walletRepository, TransactionRepositoryPort transactionRepository) {
        super(walletRepository, transactionRepository);
    }

    @Override
    protected Mono<Wallet> validate(Wallet wallet, BigDecimal amount) {
        // Validation simple : le montant doit être positif
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new IllegalArgumentException("Le montant de la recharge doit être positif"));
        }
        // On pourrait ajouter ici des règles : plafond max du wallet, statut du wallet actif, etc.
        return Mono.just(wallet);
    }

    @Override
    protected Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount) {
        // LOGIQUE MÉTIER : On AJOUTE le montant au solde
        BigDecimal newBalance = wallet.balance().add(amount);
        return Mono.just(wallet.withBalance(newBalance));
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.RECHARGE;
    }
}
```

*Lignes: 40*

---

### 📄 src\main\java\com\yowyob\template\domain\model\Transaction.java

```java
package com.yowyob.template.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Transaction(UUID id, UUID walletId, BigDecimal amount, TransactionType type, TransactionStatus status) {}


```

*Lignes: 8*

---

### 📄 src\main\java\com\yowyob\template\domain\model\TransactionStatus.java

```java
package com.yowyob.template.domain.model;

public enum TransactionStatus {
    COMPLETED,
    PENDING,
    FAILED,
}

```

*Lignes: 8*

---

### 📄 src\main\java\com\yowyob\template\domain\model\TransactionType.java

```java
package com.yowyob.template.domain.model;

public enum TransactionType {
    PAYMENT,
    RECHARGE
    // Vous pourrez ajouter TRANSFER, WITHDRAWAL plus tard
}

```

*Lignes: 8*

---

### 📄 src\main\java\com\yowyob\template\domain\model\Wallet.java

```java
package com.yowyob.template.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Wallet(UUID id, UUID ownerId, String ownerName, BigDecimal balance) {
    // Méthode helper pour l'immutabilité
    public Wallet withBalance(BigDecimal newBalance) {
        return new Wallet(id, ownerId, ownerName, newBalance);
    }
}

```

*Lignes: 12*

---

### 📄 src\main\java\com\yowyob\template\domain\ports\in\TransactionUseCase.java

```java
package com.yowyob.template.domain.ports.in;

import com.yowyob.template.domain.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TransactionUseCase {
    Mono<Transaction> createTransaction(Transaction transaction);
    Mono<Transaction> getTransactionById(UUID id);
    Flux<Transaction> getTransactionsByWalletId(UUID walletId);
}

```

*Lignes: 14*

---

### 📄 src\main\java\com\yowyob\template\domain\ports\in\WalletUseCase.java

```java
package com.yowyob.template.domain.ports.in;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WalletUseCase {
    Mono<Wallet> createWallet(Wallet wallet);
    Mono<Wallet> getWalletByOwnerId(UUID ownerId);
    Mono<Wallet> updateWallet(Wallet wallet);
    Mono<Void> deleteWallet(UUID id);
    Mono<Wallet> getWalletById(UUID id);
    Flux<Wallet> getAllWallets();
}

```

*Lignes: 17*

---

### 📄 src\main\java\com\yowyob\template\domain\ports\out\TransactionRepositoryPort.java

```java
package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TransactionRepositoryPort {
    Mono<Transaction> save(Transaction transaction);
    Mono<Transaction> getTransactionById(UUID id);
    Flux<Transaction> getTransactionsByWalletId(UUID walletId);
}

```

*Lignes: 14*

---

### 📄 src\main\java\com\yowyob\template\domain\ports\out\WalletCachePort.java

```java
package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Mono;

public interface WalletCachePort {
    Mono<Boolean> saveInCache(Wallet wallet);
}

```

*Lignes: 9*

---

### 📄 src\main\java\com\yowyob\template\domain\ports\out\WalletEventPublisherPort.java

```java
package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Mono;

public interface WalletEventPublisherPort {
    Mono<Void> publishWalletCreated(Wallet wallet);
}

```

*Lignes: 9*

---

### 📄 src\main\java\com\yowyob\template\domain\ports\out\WalletRepositoryPort.java

```java
package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface WalletRepositoryPort {
    Mono<Wallet> findById(UUID id);
    Mono<Wallet> save(Wallet wallet);
    Mono<Wallet> findByOwnerId(UUID ownerId);
    Flux<Wallet> findAllWallets();
    Mono<Void> deleteById(UUID id);
    Mono<Wallet> updateWallet(Wallet wallet);
}

```

*Lignes: 18*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\kafka\event\PaymentCommissionEvent.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.kafka.event;

import java.math.BigDecimal;
import java.util.UUID;

// Event reçu : "Ce wallet a fait un mouvement de 'baseAmount', prélevez la com !"
public record PaymentCommissionEvent(UUID ownerId, BigDecimal baseAmount) {
}

```

*Lignes: 9*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\kafka\event\WalletCreationEvent.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.kafka.event;

import java.util.UUID;

public record WalletCreationEvent(UUID ownerId, String ownerName) {
}

```

*Lignes: 7*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\kafka\KafkaPaymentConsumer.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.kafka;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.ports.in.TransactionUseCase;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.kafka.event.PaymentCommissionEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaPaymentConsumer {

    private final TransactionUseCase transactionUseCase;
    private final WalletUseCase walletUseCase;


    @Value("${application.payment.commission-rate:0.1}")
    private BigDecimal commissionRate;

    @KafkaListener(topics = "${application.kafka.topics.payment-commission}", groupId = "payment-group")
    public void consumePaymentCommission(PaymentCommissionEvent event) {


        // LOGIQUE MÉTIER : Calcul du montant à retirer (Pourcentage * MontantBase)
        BigDecimal amountToDeduct = event.baseAmount().multiply(commissionRate);

        walletUseCase.getWalletByOwnerId(event.ownerId())
                .flatMap(wallet -> {
                    Transaction domainTx = new Transaction(
                            null,
                            wallet.id(),
                            amountToDeduct,
                            TransactionType.PAYMENT,
                            TransactionStatus.PENDING
                    );

                    return transactionUseCase.createTransaction(domainTx);
                })
                .doOnSuccess(tx -> log.info("Commission prélevée avec succès. Tx ID: {}", tx.id()))
                .doOnError(e -> log.error("Échec du prélèvement de commission pour owner {}", event.ownerId(), e))
                .subscribe();
    }
}

```

*Lignes: 53*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\kafka\WalletEventConsumer.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.kafka;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.kafka.event.WalletCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Component
@RequiredArgsConstructor
public class WalletEventConsumer {

    private final WalletUseCase walletUseCase;
//    @Value("${application.kafka.topics.wallet-events}")
//    private String walletEventsTopic;
//
//    @KafkaListener(topics = "${application.kafka.topics.wallet-events}", groupId = "template-group")
//    public void consume(Wallet wallet) {
//        log.info("CONSUMER: I received an event for wallet with id : {} and owner : {}",
//                wallet.id(), wallet.ownerId());
//    }


    @KafkaListener(topics = "${application.kafka.topics.wallet-create}", groupId = "payment-group")
    public void consumeWalletCreation(WalletCreationEvent event) {
        Wallet domainWallet = new Wallet(null, event.ownerId(), event.ownerName(), BigDecimal.ZERO);

        walletUseCase.createWallet(domainWallet)
                .doOnSuccess(w -> log.info("Wallet créé: {}", w.id()))
                .doOnError(e -> log.error("Erreur création wallet", e))
                .subscribe();
    }
}

```

*Lignes: 39*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\dto\TransactionRequest.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import com.yowyob.template.domain.model.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequest(@NotNull UUID walletId, @Positive BigDecimal amount, TransactionType type) {
}

```

*Lignes: 13*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\dto\TransactionResponse.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionResponse(UUID id, UUID walletId, BigDecimal amount, TransactionType type, TransactionStatus status) {
}

```

*Lignes: 11*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\dto\WalletRequest.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import java.util.UUID;

public record WalletRequest (UUID ownerId, String ownerName) {}

```

*Lignes: 6*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\dto\WalletResponse.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletResponse(UUID id, UUID ownerId, String ownerName, BigDecimal balance) {
}

```

*Lignes: 8*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\GlobalExceptionHandler.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest;

import com.yowyob.template.domain.exception.StockFullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StockFullException.class)
    public ProblemDetail handleStockException(StockFullException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problem.setTitle("Stock Overflow");
        problem.setType(URI.create("errors/stock-full"));
        return problem;
    }
}
```

*Lignes: 21*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\TransactionController.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest;

import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.ports.in.TransactionUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionResponse;
import com.yowyob.template.infrastructure.mappers.TransactionMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Transaction Management", description = "API for transaction management")
@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionUseCase useCase;
    private final TransactionMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new recharge transaction", description = "Creates a new transaction of type RECHARGE. This endpoint is reserved for agents.")
    @ApiResponse(responseCode = "201", description = "Transaction created successfully", content = @Content(schema = @Schema(implementation = TransactionResponse.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request, only RECHARGE transactions are allowed")
    @ApiResponse(responseCode = "401", description = "Unauthorized, invalid or expired token")
    @ApiResponse(responseCode = "403", description = "Forbidden, requires ROLE_AGENT")
    public Mono<TransactionResponse> create(@RequestBody @Valid Mono<TransactionRequest> requestMono) {
        return requestMono
                .flatMap(request -> {
                    if (request.type() != TransactionType.RECHARGE) {
                        return Mono.error(new IllegalArgumentException("Cet endpoint est réservé aux recharges via Agent"));
                    }
                    return Mono.just(request);
                })
                .map(mapper::toDomain)
                .flatMap(useCase::createTransaction)
                .map(mapper::toResponse);
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new payment transaction", description = "Creates a new transaction of type PAYMENT.")
    @ApiResponse(responseCode = "201", description = "Transaction created successfully", content = @Content(schema = @Schema(implementation = TransactionResponse.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "401", description = "Unauthorized, invalid or expired token")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    public Mono<TransactionResponse> createPaymentTransaction(@RequestBody @Valid Mono<TransactionRequest> requestMono) {
        return requestMono
                .flatMap(request -> {
                    if (request.type() != TransactionType.PAYMENT) {
                        return Mono.error(new IllegalArgumentException("Cet endpoint est réservé aux recharges de type PAYMENT"));
                    }
                    return Mono.just(request);
                })
                .map(mapper::toDomain)
                .flatMap(useCase::createTransaction)
                .map(mapper::toResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get transaction by ID", description = "Retrieves transaction details by its unique ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved transaction", content = @Content(schema = @Schema(implementation = TransactionResponse.class)))
    @ApiResponse(responseCode = "404", description = "Transaction not found")
    public Mono<TransactionResponse> findById(@Parameter(description = "ID of the transaction to retrieve") @PathVariable("id") UUID id) {
        return useCase.getTransactionById(id)
                .map(mapper::toResponse);
    }

    @GetMapping("/Wallet/{walletId}")
    @Operation(summary = "Get transactions by wallet ID", description = "Retrieves a list of transactions for a given wallet ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved transactions", content = @Content(schema = @Schema(implementation = TransactionResponse.class)))
    public Flux<TransactionResponse> findByWalletId(@Parameter(description = "ID of the wallet") @PathVariable("walletId") UUID walletId) {
        return useCase.getTransactionsByWalletId(walletId)
                .map(mapper::toResponse);
    }
}

```

*Lignes: 90*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\inbound\rest\WalletController.java

```java
package com.yowyob.template.infrastructure.adapters.inbound.rest;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletResponse;
import com.yowyob.template.infrastructure.mappers.WalletMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

@Tag(name = "Wallet Management", description = "API for wallet management")
@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletUseCase useCase;
    private final WalletMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new wallet", description = "Creates a new wallet for a user.")
    @ApiResponse(responseCode = "201", description = "Wallet created successfully", content = @Content(schema = @Schema(implementation = WalletResponse.class)))
    public Mono<WalletResponse> create(@RequestBody @Valid Mono<WalletRequest> requestMono) {
        return requestMono
                .map(mapper::toDomain)
                .flatMap(useCase::createWallet)
                .map(mapper::toResponse);
    }

    @GetMapping("/{id}/can-operate")
    public Mono<Boolean> canOperate(@PathVariable UUID id) {
        return useCase.getWalletById(id)
                .map(wallet -> wallet.balance().compareTo(BigDecimal.ZERO) > 0);
    }

    @GetMapping
    @Operation(summary = "Get all wallets", description = "Retrieves a list of all wallets.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all wallets", content = @Content(schema = @Schema(implementation = WalletResponse.class)))
    public Flux<WalletResponse> getAllWallets() {
        return useCase.getAllWallets()
                .map(mapper::toResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get wallet by ID", description = "Retrieves wallet details by its unique ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved wallet", content = @Content(schema = @Schema(implementation = WalletResponse.class)))
    @ApiResponse(responseCode = "404", description = "Wallet not found")
    public Mono<WalletResponse> getWallet(@Parameter(description = "ID of the wallet to retrieve") @PathVariable UUID id) {
        return useCase.getWalletById(id)
                .map(mapper::toResponse);
    }

    @GetMapping("/owner/{id}")
    @Operation(summary = "Get wallet by owner ID", description = "Retrieves wallet details by the owner's unique ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved wallet", content = @Content(schema = @Schema(implementation = WalletResponse.class)))
    @ApiResponse(responseCode = "404", description = "Wallet not found for the given owner")
    public Mono<WalletResponse> getWalletOwner(@Parameter(description = "ID of the wallet owner") @PathVariable UUID id) {
        return useCase.getWalletByOwnerId(id)
                .map(mapper::toResponse);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a wallet", description = "Updates the details of an existing wallet.")
    @ApiResponse(responseCode = "200", description = "Wallet updated successfully", content = @Content(schema = @Schema(implementation = WalletResponse.class)))
    @ApiResponse(responseCode = "404", description = "Wallet not found")
    public Mono<WalletResponse> updateWallet(@Parameter(description = "ID of the wallet to update") @PathVariable UUID id, @RequestBody @Valid WalletRequest request) {
        Wallet wallet = new Wallet(id, request.ownerId(), request.ownerName(), null);
        return useCase.updateWallet(wallet)
                .map(mapper::toResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a wallet", description = "Deletes a wallet by its unique ID.")
    @ApiResponse(responseCode = "204", description = "Wallet deleted successfully")
    @ApiResponse(responseCode = "404", description = "Wallet not found")
    public Mono<Void> deleteWallet(@Parameter(description = "ID of the wallet to delete") @PathVariable UUID id) {
        return useCase.deleteWallet(id);
    }
}
```

*Lignes: 94*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\cache\RedisAdapter.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.cache;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletCachePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RedisAdapter implements WalletCachePort {
    private final ReactiveRedisTemplate<String, Object> redisTemplate;

    @Override
    public Mono<Boolean> saveInCache(Wallet wallet) {
        return redisTemplate.opsForValue()
                .set("wallet:" + wallet.id(), wallet, Duration.ofMinutes(10));
    }
}
```

*Lignes: 21*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\messaging\KafkaAdapter.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.messaging;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletEventPublisherPort;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class KafkaAdapter implements WalletEventPublisherPort {

    private final ReactiveKafkaProducerTemplate<String, Object> kafkaTemplate;

    @Value("${application.kafka.topics.wallet-create}")
    private String walletEventsTopic;

    public KafkaAdapter(ReactiveKafkaProducerTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<Void> publishWalletCreated(Wallet wallet) {
        return kafkaTemplate.send(walletEventsTopic, wallet.id().toString(), wallet)
                .then();
    }
}
```

*Lignes: 29*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\persistence\entity\TransactionEntity.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table("transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {
    @Id
    private UUID id;
    private UUID walletId;
    private BigDecimal amount;
    private String type;
    private String status;
}

```

*Lignes: 24*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\persistence\entity\WalletEntity.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table("wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity implements Persistable<UUID> {
    @Id
    private UUID id;
    private UUID ownerId;
    private String ownerName;
    private BigDecimal balance;

    // 2. Ajouter un champ qui n'est pas dans la BDD
    @Transient
    private boolean isNew = false;

    // 3. Implémenter la méthode getId() (Lombok le fait souvent déjà via @Getter, mais c'est bien de l'avoir)
    @Override
    public UUID getId() {
        return id;
    }

    // 4. C'est ici que la magie opère
    @Override
    public boolean isNew() {
        // Si isNew est true OU si l'id est null, Spring fera un INSERT
        return isNew || id == null;
    }

    // Helper pour créer une entité marquée comme "nouvelle"
    public static WalletEntity createNew(UUID id, UUID ownerId, String ownerName, BigDecimal balance) {
        WalletEntity w = new WalletEntity(id, ownerId, ownerName, balance, true); // on met isNew à true
        return w;
    }
}

```

*Lignes: 50*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\persistence\PostgresTransactionAdapter.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.persistence;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.repository.TransactionR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostgresTransactionAdapter implements TransactionRepositoryPort {

    private final TransactionR2dbcRepository repository;

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        // 1. Map Domain -> Entity
        TransactionEntity entity = new TransactionEntity(
                transaction.id(),
                transaction.walletId(),
                transaction.amount(),
                transaction.type().name(),
                transaction.status().name()
        );

        // 2. Save & Map Entity -> Domain
        return repository.save(entity)
                .map(this::mapToDomain);
    }

    @Override
    public Mono<Transaction> getTransactionById(UUID id) {
        return repository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Flux<Transaction> getTransactionsByWalletId(UUID walletId) {
        return repository.findAllByWalletId(walletId) // Retourne Flux<TransactionEntity>
                .map(this::mapToDomain);              // Convertit en Flux<Transaction>
    }

    // Méthode utilitaire pour faire la conversion proprement
    private Transaction mapToDomain(TransactionEntity entity) {
        return new Transaction(
                entity.getId(),
                entity.getWalletId(),
                entity.getAmount(),
                // Attention à la conversion String -> Enum ici
                TransactionType.valueOf(entity.getType()),
                TransactionStatus.valueOf(entity.getStatus())
        );
    }
}

```

*Lignes: 62*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\persistence\PostgresWalletAdapter.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.persistence;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.WalletEntity;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.repository.WalletR2dbcRepository;

import com.yowyob.template.infrastructure.mappers.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostgresWalletAdapter implements WalletRepositoryPort {

    private final WalletR2dbcRepository repository;
    private final WalletMapper mapper;


    @Override
    public Mono<Wallet> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain); // Convertit l'Entity en Domain si trouvé
    }

    @Override
    public Mono<Wallet> save(Wallet wallet) {
        WalletEntity entity = mapper.toEntity(wallet);
        entity.setNew(true);

        return repository.save(entity)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Wallet> findByOwnerId(UUID ownerId) {
        return repository.findByOwnerId(ownerId)
                .map(mapper::toDomain); // Convertit l'Entity en Domain si trouvé
    }

    @Override
    public Flux<Wallet> findAllWallets() {
        return repository.findAll()
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Wallet> updateWallet(Wallet wallet) {
        return repository.findById(wallet.id())

                .switchIfEmpty(Mono.error(new RuntimeException("Wallet not found for update")))

                .map(entity -> {
                    entity.setOwnerId(wallet.ownerId());
                    entity.setBalance(wallet.balance());
                    entity.setNew(false);
                    return entity;
                })

                .flatMap(repository::save)

                .map(mapper::toDomain);
    }
}

```

*Lignes: 74*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\persistence\repository\TransactionR2dbcRepository.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.persistence.repository;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface TransactionR2dbcRepository extends R2dbcRepository<TransactionEntity, UUID> {
    Flux<TransactionEntity> findAllByWalletId(UUID walletId);
}
```

*Lignes: 12*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\adapters\outbound\persistence\repository\WalletR2dbcRepository.java

```java
package com.yowyob.template.infrastructure.adapters.outbound.persistence.repository;

import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.WalletEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WalletR2dbcRepository extends R2dbcRepository<WalletEntity, UUID> {
    Mono<WalletEntity> findByOwnerId(UUID ownerId);
}

```

*Lignes: 12*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\config\KafkaConfig.java

```java
package com.yowyob.template.infrastructure.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ReactiveKafkaProducerTemplate<String, Object> reactiveKafkaProducerTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);

        SenderOptions<String, Object> senderOptions = SenderOptions.create(props);

        return new ReactiveKafkaProducerTemplate<>(senderOptions);
    }
}

```

*Lignes: 32*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\config\OpenApiConfig.java

```java
package com.yowyob.template.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Notification Service API")
            .version("v1.0")
            .description("API for managing notifications, services, and templates.")
            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .servers(Arrays.asList(
            new Server().url("https://payment-service.pynfi.com"),
            new Server().url("http://localhost:8090")));

  }
}
```

*Lignes: 29*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\config\RedisConfig.java

```java
package com.yowyob.template.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.*;

@Configuration
public class RedisConfig {

    @Bean
    public ReactiveRedisTemplate<String, Object> reactiveRedisTemplate(
            ReactiveRedisConnectionFactory factory) {

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new JavaTimeModule());

        Jackson2JsonRedisSerializer<Object> jsonSerializer =
                new Jackson2JsonRedisSerializer<>(mapper, Object.class);

        RedisSerializationContext<String, Object> context =
                RedisSerializationContext.<String, Object>newSerializationContext(new StringRedisSerializer())
                        .value(jsonSerializer)
                        .hashValue(jsonSerializer)
                        .build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}

```

*Lignes: 35*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\config\SecurityConfig.java

```java
package com.yowyob.template.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Value("${application.security.jwt.secret}")
    private String secretKey;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/actuator/**").permitAll()
                        .pathMatchers("/swagger-ui.html").permitAll()
                        .pathMatchers("/swagger-ui/**").permitAll()
                        .pathMatchers("/v3/api-docs/**").permitAll()
                        .pathMatchers("/webjars/swagger-ui/**").permitAll()
                        .pathMatchers("/api/v1/wallets/**").permitAll()
                        .pathMatchers("/api/v1/transactions/**").permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtDecoder(jwtDecoder())))
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Your allowed origins
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:3999",
                "http://168.119.122.86:3999"));

        // Your allowed methods
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allowed headers
        configuration.setAllowedHeaders(List.of("*"));

        // Allow credentials
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA256");

        return NimbusReactiveJwtDecoder.withSecretKey(secretKeySpec).build();
    }
}

```

*Lignes: 79*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\config\WebClientConfig.java

```java
package com.yowyob.template.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
//
//    @Bean
//    public StockApiClient stockApiClient(WebClient.Builder builder,
//                                         @Value("${application.external.stock-service-url}") String url) {
//
//        WebClient webClient = builder.baseUrl(url).build();
//        WebClientAdapter adapter = WebClientAdapter.create(webClient);
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
//
//        return factory.createClient(StockApiClient.class);
//    }
}
```

*Lignes: 23*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\mappers\TransactionMapper.java

```java
package com.yowyob.template.infrastructure.mappers;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionResponse;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toDomain(TransactionRequest request);
    TransactionResponse toResponse(Transaction domain);

    TransactionEntity toEntity(Transaction domain);
    Transaction toDomain(TransactionEntity entity);
}

```

*Lignes: 17*

---

### 📄 src\main\java\com\yowyob\template\infrastructure\mappers\WalletMapper.java

```java
package com.yowyob.template.infrastructure.mappers;


import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletResponse;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.WalletEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    Wallet toDomain(WalletRequest request);
    WalletResponse toResponse(Wallet domain);

    WalletEntity toEntity(Wallet domain);
    Wallet toDomain(WalletEntity entity);
}

```

*Lignes: 18*

---

### 📄 src\main\java\com\yowyob\template\PaymentServiceApplication.java

```java
package com.yowyob.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}

```

*Lignes: 14*

---

### 📄 src\main\resources\application.yml

```yaml
server:
  port: 8090
  forward-headers-strategy: framework


spring:
  application:
    name: payment-service
    
  docker:
    compose:
      enabled: false

  # POSTGRESQL (R2DBC)
  r2dbc:
    url: r2dbc:postgresql://${DB_HOST:168.119.122.86}:${DB_PORT:5432}/${DB_NAME:payment_db}
    username: ${DB_USERNAME:master}
    password: ${DB_PASSWORD:Azerty1234*}
#    url: r2dbc:postgresql://localhost:5432/reactivedb
#    username: master
#    password: Azerty1234
    pool:
      enabled: true
      initial-size: 1
      max-size: 5
      max-idle-time: 30m
      max-life-time: 10m
      acquire-retry: 3
      max-acquire-time: 30s
      validation-query: SELECT 1
  sql:
    init:
      mode: never

  # REDIS CLUSTER 
  data:
    redis:
      host: ${REDIS_HOST:168.119.122.86}
      port: ${REDIS_PORT:7000}
      password: ${REDIS_PASSWORD:password}
      cluster:
        enabled: false 

  # KAFKA 
  kafka:
    bootstrap-servers: ${KAFKA_HOST:168.119.122.86}:${KAFKA_PORT:9092}
    consumer:
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring.json.trusted.packages: "*"
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer

# CUSTOM CONFIG 
application:
  external:
    stock-service-url: http://${EXTERNAL_HOST:168.119.122.86}:8081
  security:
    jwt:
      secret: 404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
  kafka:
    topics:
      wallet-create: wallet-create-topic
      payment-commission: transaction-commission-topic


  payment:
    commission-rate: 0.1

management:
  endpoints:
    web:
      exposure:
        include: ["health","info","prometheus"]
  endpoint:
    health:
      show-details: "always"
      probes:
        enabled: true
  metrics:
    export:
      prometheus:
        enabled: true

# RESILIENCE4J 
resilience4j:
  circuitbreaker:
    instances:
      stock-service:
        failureRateThreshold: 50
        waitDurationInOpenState: 5s
        slidingWindowSize: 5

```

*Lignes: 96*

---

### 📄 src\main\resources\db\changelog\changes\v1.0-create-initial-schema.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
        http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.3.xsd">


    <changeSet id="v1.0-create-wallets" author="payment-service">
        <preConditions onFail="MARK_RAN">
            <not><tableExists tableName="wallets"/></not>
        </preConditions>
        <createTable tableName="wallets">
            <column name="id" type="UUID" defaultValueComputed="gen_random_uuid()">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="owner_id" type="UUID">
                <constraints nullable="false"/>
            </column>
            <column name="owner_name" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <column name="balance" type="DECIMAL(19,4)" defaultValueNumeric="0.00">
                <constraints nullable="false"/>
            </column>
            <column name="created_at" type="TIMESTAMP" defaultValueComputed="CURRENT_TIMESTAMP"/>
        </createTable>
    </changeSet>

    <!-- Index pour les lookups par owner_id (findByOwnerId) -->
    <changeSet id="v1.0-idx-wallets-owner-id" author="payment-service">
        <preConditions onFail="MARK_RAN">
            <not><indexExists tableName="wallets" indexName="idx_wallets_owner_id"/></not>
        </preConditions>
        <createIndex tableName="wallets" indexName="idx_wallets_owner_id">
            <column name="owner_id"/>
        </createIndex>
    </changeSet>


    <!-- ================================================================ -->
    <!-- 2. TABLE : transactions                                           -->
    <!--    Entité : TransactionEntity.java                               -->
    <!--    Champs : id, wallet_id, amount, type, status, created_at      -->
    <!--    type   : PAYMENT | RECHARGE (enum TransactionType)            -->
    <!--    status : PENDING | COMPLETED | FAILED (enum TransactionStatus) -->
    <!-- ================================================================ -->

    <changeSet id="v1.0-create-transactions" author="payment-service">
        <preConditions onFail="MARK_RAN">
            <not><tableExists tableName="transactions"/></not>
        </preConditions>
        <createTable tableName="transactions">
            <column name="id" type="UUID" defaultValueComputed="gen_random_uuid()">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="wallet_id" type="UUID">
                <constraints nullable="false"
                             foreignKeyName="fk_transaction_wallet"
                             referencedTableName="wallets"
                             referencedColumnNames="id"/>
            </column>
            <column name="amount" type="DECIMAL(19,4)">
                <constraints nullable="false"/>
            </column>
            <!-- PAYMENT, RECHARGE -->
            <column name="type" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <!-- PENDING, COMPLETED, FAILED -->
            <column name="status" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <column name="created_at" type="TIMESTAMP" defaultValueComputed="CURRENT_TIMESTAMP"/>
        </createTable>
    </changeSet>

    <!-- Index pour les lookups par wallet_id (findAllByWalletId) -->
    <changeSet id="v1.0-idx-transactions-wallet-id" author="payment-service">
        <preConditions onFail="MARK_RAN">
            <not><indexExists tableName="transactions" indexName="idx_transactions_wallet_id"/></not>
        </preConditions>
        <createIndex tableName="transactions" indexName="idx_transactions_wallet_id">
            <column name="wallet_id"/>
        </createIndex>
    </changeSet>

</databaseChangeLog>
```

*Lignes: 88*

---

### 📄 src\main\resources\db\changelog\db.changelog-master.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
        http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.3.xsd">

    <include file="classpath:db/changelog/changes/v1.0-create-initial-schema.xml"/>

</databaseChangeLog>
```

*Lignes: 10*

---

### 📄 src\main\resources\prod.application.yml

```yaml
server:
  port: 8090

spring:
  application:
    name: payment-service
    
  docker:
    compose:
      enabled: false

  # ------------------------------------------------------------------
  # DATABASE — Liquibase
  # ------------------------------------------------------------------
  liquibase:
    url: jdbc:postgresql://${DB_HOST}:${DB_PORT:5432}/${DB_NAME:payment}
    user: ${DB_LIQUIBASE_USERNAME}
    password: ${DB_LIQUIBASE_PASSWORD}
    enabled: true
    change-log: classpath:db/changelog/db.changelog-master.yaml
    default-schema: ${DB_SCHEMA:public}
    liquibase-schema: ${DB_SCHEMA:public}


  # POSTGRESQL (R2DBC)
  r2dbc:
    url: r2dbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:payment}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:password}
    pool:
      enabled: true
      initial-size: 1
      max-size: 5
      max-idle-time: 30m
      max-life-time: 10m
      acquire-retry: 3
      max-acquire-time: 30s
      validation-query: SELECT 1
  sql:
    init:
      mode: never

  # ------------------------------------------------------------------
  # REDIS CLUSTER
  # ------------------------------------------------------------------
  data:
    redis:
      username: ${REDIS_USERNAME}
      password: ${REDIS_PASSWORD}
      cluster:
        nodes:
          - ${REDIS_HOST}:7001
          - ${REDIS_HOST}:7002
          - ${REDIS_HOST}:7003
          - ${REDIS_HOST}:7004
          - ${REDIS_HOST}:7005
          - ${REDIS_HOST}:7006
        max-redirects: 3
      lettuce:
        pool:
          max-active: 16
          max-idle: 8
          min-idle: 2
        cluster:
          refresh:
            adaptive: true
            period: 30s
            dynamic-refresh-sources: false

  # ------------------------------------------------------------------
  # KAFKA — Connexion sécurisée SASL/SCRAM-SHA-256
  # ------------------------------------------------------------------
  kafka:
    bootstrap-servers: ${KAFKA_HOST}:${KAFKA_PORT:29092}

    # ── Authentification SASL/SCRAM-SHA-256 ────────────────────────
    properties:
      security.protocol: SASL_PLAINTEXT
      sasl.mechanism: SCRAM-SHA-256
      sasl.jaas.config: >
        org.apache.kafka.common.security.scram.ScramLoginModule required
        username="${KAFKA_BACKEND_USER}"
        password="${KAFKA_BACKEND_PASSWORD}";
    consumer:
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring.json.trusted.packages: "*"
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer

# CUSTOM CONFIG 
application:
  external:
    stock-service-url: http://${EXTERNAL_HOST:localhost}:8081
  security:
    jwt:
      secret: 404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970

  kafka:
    topics:
      wallet-create: wallet-create-topic
      payment-commission: transaction-commission-topic

  payment:
    commission-rate: 0.05
  
management:
  endpoints:
    web:
      exposure:
        include: ["health","info","prometheus"]
  endpoint:
    health:
      show-details: "always"
      probes:
        enabled: true
  metrics:
    export:
      prometheus:
        enabled: true

# RESILIENCE4J 
resilience4j:
  circuitbreaker:
    instances:
      stock-service:
        failureRateThreshold: 50
        waitDurationInOpenState: 5s
        slidingWindowSize: 5

```

*Lignes: 133*

---

### 📄 src\main\resources\schema.sql

```sql
-- Garde ta configuration UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS wallets (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    owner_id UUID NOT NULL,
    owner_name VARCHAR(50) NOT NULL,
    balance DECIMAL(19, 4) NOT NULL DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS transactions (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    wallet_id UUID NOT NULL,
    amount DECIMAL(19, 4) NOT NULL,
    type VARCHAR(50) NOT NULL, -- PAYMENT, RECHARGE, TRANSFER
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_wallet FOREIGN KEY (wallet_id) REFERENCES wallets(id)
    );
```

*Lignes: 20*

---

### 📄 src\test\java\com\yowyob\template\PaymentServiceApplicationTests.java

```java
package com.yowyob.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

```

*Lignes: 14*

---

## Statistiques

- **Total de fichiers analysés:** 54
- **Total de lignes de code:** 1 849
- **Moyenne de lignes par fichier:** 34

### Répartition par type de fichier

- **.java:** 46 fichiers
- **.yml:** 3 fichiers
- **.xml:** 3 fichiers
- **.yaml:** 1 fichier
- **.sql:** 1 fichier

---

*Contexte généré automatiquement pour analyse par IA*
