package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.RecipientService;

import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.RecipientService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {
    private RecipientRepository recipientRepository;
}
