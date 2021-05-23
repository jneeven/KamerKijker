from dataclasses import dataclass, field
from datetime import datetime
from enum import Enum
from typing import Optional, Sequence

"""
These just replicate the database specification. See the backend folder for details.
"""


@dataclass
class Motion:
    motie_id: int
    title: str
    submit_date: datetime
    vote_date: datetime
    document_url: str
    total_votes: int
    submitter_id: int
    first_signatory_id: Optional[int] = None
    second_signatory_id: Optional[int] = None
    co_submitter_id: Optional[int] = None
    vote_ids: Sequence[int] = field(default_factory=lambda: [])


@dataclass
class Person:
    first_name: str
    last_name: str
    party_id: int


class Result(Enum):
    For: 0
    Against: 1


@dataclass
class Vote:
    result: Result
    votes: int
    motion_id: int
    party_id: int


@dataclass
class Party:
    name: str
    code: str
